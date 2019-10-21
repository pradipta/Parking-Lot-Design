
public class ParkingSpot {

	//A parking spot should have a spotNumber, a boolean value to identify if it is occupied or is vacant and the car that has been parked on it
	private int spotNumber;
	private boolean isOccupied;
	private Car carHere;

	//Constructor
	public ParkingSpot(int spotNumber) {
		this.spotNumber = spotNumber;
		this.isOccupied = false;
		System.out.println("Parking Spot: " + this.spotNumber + " created.");
	}

	//Getters and setters
	public boolean isOccupied() {
		return this.isOccupied;
	}

	public void setOccupancy(boolean value, Car car) {
		this.isOccupied = value;
		this.carHere = car;
	}

	public int getSpotNumber() {
		return this.spotNumber;
	}

	public Car getCar() {
		return this.carHere;
	}
}
