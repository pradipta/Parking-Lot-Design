
public class ParkingManagement {
	public static void main (String args []) {
		ParkingLot mallParking = new ParkingLot(10);
		Car c1 = new Car("KA-01-HH-1234", "blue");
		Car c2 = new Car("KA-01-HH-9999", "blue");
		Car c3 = new Car("KA-03-HJ-0443", "red");
		Car c4 = new Car("AS-23-C-6923", "silver");
		
		if (mallParking.bookParking(c1)) {
			System.out.println ("Booked by "+c1.getRegistration()+" at spot "+c1.getSpot().getSpotNumber());
		}else {
			System.out.println ("Booking failed");
		}
		
		if (mallParking.bookParking(c2)) {
			System.out.println ("Booked by "+c2.getRegistration()+" at spot "+c2.getSpot().getSpotNumber());
		}else {
			System.out.println ("Booking failed");
		}
		
		mallParking.checkout(c2);
		
		if (mallParking.bookParking(c4)) {
			System.out.println ("Booked by "+c4.getRegistration()+" at spot "+c4.getSpot().getSpotNumber());
		}else {
			System.out.println ("Booking failed");
		}
		
		mallParking.getParkingSpotsOccupiedByColor ("blue");
		mallParking.getParkingSpotsOccupiedByColor ("black");
		
		Car c5 = new Car("AS-23-C-6923", "black");
		
		if (mallParking.bookParking(c5)) {
			System.out.println ("Booked by "+c5.getRegistration()+" at spot "+c5.getSpot().getSpotNumber());
		}else {
			System.out.println ("Booking failed");
		}
		
		mallParking.getParkingSpotsOccupiedByColor ("black");
		
	}
}
