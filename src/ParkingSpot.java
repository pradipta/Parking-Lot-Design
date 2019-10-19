
public class ParkingSpot {
	
	private int spotNumber;
	private boolean isOccupied;
	private Car carHere;
	
	public ParkingSpot (int spotNumber) {
		this.spotNumber = spotNumber;
		this.isOccupied = false;
		System.out.println("Parking Spot: "+this.spotNumber+" created.");
	}
	
	public boolean isOccupied () {
		return this.isOccupied;
	}
	
	public void setOccupancy(boolean value, Car car) {
		this.isOccupied = value;
		this.carHere = car;
	}
	
	public int getSpotNumber () {
		return this.spotNumber;
	}

	public Car getCar() {
		// TODO Auto-generated method stub
		return null;
	}
}
