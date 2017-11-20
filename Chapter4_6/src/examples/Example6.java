package examples;

public class Example6 {

	public static void main(String[] args) {

		int counts[] = new int[3]; //same as below
		int [] counters = new int[5]; //same as above
		
		counts[0] = 99;
		counts[1] = 1;
		counts[2] = 15;
		
		int riders[][] = new int[7][];		
		//irregular shaped 2d arrays
		riders[0] = new int[10]; 
		riders[1] = new int[3];
		riders[2] = new int[9];
		
		//arrays have public variable: length
		
		System.out.println("counts length: " + counts.length);
		
		//for each example, notice it mimics pass by VALUE not reference
		for(int x : counts) {
			x = x+9;
			System.out.println(x + " is here!");	
		}
		
		System.out.println("counts[0] = " + counts[0]);
	}

}
