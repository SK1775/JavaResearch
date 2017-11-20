package examples;

class Vehicle{
	int passengers;
	int fuelcap;
	int mpg;
}

public class VehicleExample {

	public static void main(String[] args) {
		Vehicle minivan = new Vehicle();
		int range;
		
		minivan.passengers = 7;
		minivan.fuelcap = 18;
		minivan.mpg = 21;
		
		range = minivan.fuelcap * minivan.mpg;
		
		System.out.println("Minivan carries " + minivan.passengers + " with a range of " + range);
		
		Vehicle car2 = minivan;
		car2.passengers = 2;
		
		System.out.println(minivan.passengers);

	}

}
