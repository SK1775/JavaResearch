package examples;

class Vehicle2{
	int passengers;
	int fuelcap;
	int mpg;
	
	Vehicle2(int p, int f, int m){
		passengers = p;
		fuelcap = f;
		mpg = m;
	}
	
	int range(){	
		return mpg*fuelcap;
	}
	
	double fueldneeded(int miles) {
		return (double) miles / mpg;
	}
}

public class VehicleExample2 {

	public static void main(String[] args) {
		Vehicle2 minivan = new Vehicle2(7, 16, 21);
		Vehicle2 sportscar = new Vehicle2(2, 14, 12);
		
		double gallons;
		int dist= 252;
		
		gallons = minivan.fueldneeded(dist);
		
		System.out.println("To go " + dist + " miles minivan needs " + gallons + " gallons of fuel.");
		gallons = sportscar.fueldneeded(dist);
		System.out.println("To go " + dist + " miles sports care needs " + gallons + " gallons of fuel.");
		
	}
}
