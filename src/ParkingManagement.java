
public class ParkingManagement {
	public static void main(String args[]) {
		
		//Initiate a parking lot with maximum number of available spots
		ParkingLot mallParking = new ParkingLot(10);

		//Initiate instances of cars for testing various scenarios, with color and licence plate number
		Car c1 = new Car("KA-01-HH-1234", "blue");
		Car c2 = new Car("KA-01-HH-9999", "blue");
		Car c3 = new Car("KA-03-HJ-0443", "red");
		Car c4 = new Car("AS-23-C-6923", "silver");

		//Park car c1. Should get slot 1
		if (mallParking.bookParking(c1)) {
			System.out.println("Booked by " + c1.getRegistration() + " at spot " + c1.getSpot().getSpotNumber());
		} else {
			System.out.println("Booking failed");
		}

		//Park car c2. Should get slot 2
		if (mallParking.bookParking(c2)) {
			System.out.println("Booked by " + c2.getRegistration() + " at spot " + c2.getSpot().getSpotNumber());
		} else {
			System.out.println("Booking failed");
		}

		//Checkout car c2, spot 2 is now empty
		mallParking.checkout(c2);

		////Park car c4. Should get slot 2
		if (mallParking.bookParking(c4)) {
			System.out.println("Booked by " + c4.getRegistration() + " at spot " + c4.getSpot().getSpotNumber());
		} else {
			System.out.println("Booking failed");
		}

		//Get spots where car of a particular color has been parked
		mallParking.getParkingSpotsOccupiedByColor("blue");
		mallParking.getParkingSpotsOccupiedByColor("black");

		////Park car c5. Should get slot 3
		Car c5 = new Car("AS-23-C-6923", "black");

		if (mallParking.bookParking(c5)) {
			System.out.println("Booked by " + c5.getRegistration() + " at spot " + c5.getSpot().getSpotNumber());
		} else {
			System.out.println("Booking failed");
		}

		//Checkout car c4 from slot 2, slot 2 gets emplty and park car c6 which should get slot 2
		mallParking.checkout(c4);
		Car c6 = new Car("AS-03-A-6923", "violet");
		
		if (mallParking.bookParking(c6)) {
			System.out.println("Booked by " + c6.getRegistration() + " at spot " + c6.getSpot().getSpotNumber());
		} else {
			System.out.println("Booking failed");
		}

		mallParking.getParkingSpotsOccupiedByColor("black");

	}
}
