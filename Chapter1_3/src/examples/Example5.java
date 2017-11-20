package examples;

public class Example5 {

	public static void main(String[] args) {
		int i;
		for(i=0; i < 10; i++) {
			if( (i % 2) != 0) continue;
				System.out.println(i); //if the number is odd this line is never ran
			System.out.println("thanks!"); // neither is this one
		}

	}

}
