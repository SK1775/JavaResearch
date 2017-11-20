package examples;

public class Example4 {

	public static void main(String[] args) {
		int x=0;
		int y=9;
		for(x=0; x < 20; x++) {
			System.out.println("y + x = " + (x+y) );
		}
		
		while(y < 12) {
			System.out.println("hello");
			y++;
		}
		
		char let1 = 'a';
		char let2 = 'b';
		int let3 =  (let1 + let2);
		System.out.println(let3);

		switch(let1) {
			case 'b': 
				System.out.println("it's a b");
				break;
			case 'a':
				System.out.println("its an a");
				break;
			default:
				System.out.println("something went wrong");
				break;
		}
		
	}

}
