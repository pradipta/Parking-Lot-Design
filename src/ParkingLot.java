import java.util.*;

public class ParkingLot {

	// Maintain a list of all spots in the parking lot
	private ArrayList<ParkingSpot> spots;

	// A heap to maintain the nearest available parking, for O(1) lookup
	private PriorityQueue<ParkingSpot> spotsAvailable;

	// A color to spot map to get spots for a particular color
	private HashMap<String, ArrayList<ParkingSpot>> colorToSpotMap;

	private int maxCapacity;
	private int totalCars;

	// Constructors
	public ParkingLot(int maxCapacity) {
		this.spots = new ArrayList<>();
		this.colorToSpotMap = new HashMap<String, ArrayList<ParkingSpot>>();

		// Heapify wrt spotNumber
		this.spotsAvailable = new PriorityQueue<ParkingSpot>(new Comparator<ParkingSpot>() {
			@Override
			public int compare(ParkingSpot o1, ParkingSpot o2) {
				return Integer.compare(o1.getSpotNumber(), o2.getSpotNumber());
			}
		});

		this.maxCapacity = maxCapacity;
		this.totalCars = 0;
		for (int i = 0; i < maxCapacity; i++) {
			ParkingSpot newSpot = new ParkingSpot(i + 1);
			this.spots.add(newSpot);
			this.spotsAvailable.add(newSpot);
		}
	}

	public boolean bookParking(Car c) {
		
		if (totalCars == maxCapacity) {
			System.out.println("Parking full!");
			return false;
		}
		
		ParkingSpot newSpot = spotsAvailable.poll();
		c.setParkingLotAllocated(newSpot);
		newSpot.setOccupancy(true, c);
		
		//add car to colorToSpot map
		addToMap(c, newSpot);
		this.totalCars++;
		System.out.println(c.getRegistration() + " has been parked in parking spot: " + newSpot.getSpotNumber());
		return true;Ï
	}

	private void addToMap(Car c, ParkingSpot newSpot) {
		if (this.colorToSpotMap.containsKey(c.getColor())) {
			colorToSpotMap.get(c.getColor()).add(newSpot);
			return;
		}
		ArrayList<ParkingSpot> newList = new ArrayList<ParkingSpot>();
		newList.add(newSpot);
		colorToSpotMap.put(c.getColor(), newList);

	}

	public void checkout(Car c) {
		if (c.isInLot()) {
			ParkingSpot newSpot = c.getSpot();
			spotsAvailable.add(newSpot);
			this.totalCars--;
			// TODO Remove from map method
			removeFromMap(c);
			c.setParkingLotAllocated(null);
			System.out.println("Car " + c.getRegistration() + " checked out");
		} else {
			System.out.println("Car not present");
		}
	}

	private void removeFromMap(Car c) {
		ArrayList<ParkingSpot> spots = new ArrayList<ParkingSpot>();
		spots = colorToSpotMap.get(c.getColor());
		if (spots.size() == 1) {
			// only one car
			colorToSpotMap.remove(c.getColor());
		} else {
			for (ParkingSpot eachSpot : spots) {
				if (eachSpot.getCar() == c) {
					spots.remove(eachSpot);
					break;
				}
			}
		}
	}

	public void getParkingSpotsOccupiedByColor(String color) {
		if (this.colorToSpotMap.containsKey(color)) {
			ArrayList<ParkingSpot> listForThisColor = new ArrayList<>();
			listForThisColor = colorToSpotMap.get(color);
			System.out.println("Cars of the color " + color + " are parked in the following spots:");
			for (ParkingSpot spot : listForThisColor) {
				System.out.println(spot.getSpotNumber());
			}
		} else {
			System.out.println("No cars of " + color + " color in parking lot now");
		}

	}
}
