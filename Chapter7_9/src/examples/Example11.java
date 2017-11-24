package examples;

public class Example11 {
	public static void main(String args[]) {
		int numerator[] = {2, 4, 64, 128, 256, 512};
		int denominator[] = {2, 4, 0, 8};
		
		for(int i=0; i < numerator.length; i++) {
			try {
				System.out.println(numerator[i] + " / " + denominator[i] + " = " + numerator[i]/denominator[i]);
				
			}catch (ArithmeticException exc) {
				System.out.println("dividing by zero?? this isn't calculus!");
				
			}catch (ArrayIndexOutOfBoundsException exc){
				System.out.println("no match...? we're out of denoms!");
				System.out.println("incrementing i to avoid a repeat of this failure! SOS");
				i = numerator.length;
				
			}finally {
				System.out.println("I run no matter what!");
			}
		}
		
		try {
			for(int i=0; i < 2; i++) {
				try {
					System.out.println(numerator[i] + " / " + denominator[i] + " = " + numerator[i]/denominator[i]);
					
				}catch (ArithmeticException exc) {
					System.out.println("dividing by zero?? this isn't calculus!");
					
				}catch (ArrayIndexOutOfBoundsException exc){
					System.out.println("no match...? we're out of denoms!");
					System.out.println("incrementing i to avoid a repeat of this failure! SOS");
					i = numerator.length;
					
				}
			}
		}finally {
			System.out.println("I run no matter what!");
		}
		for(int i=0; i < numerator.length; i++) {
			try {
				System.out.println(numerator[i] + " / " + denominator[i] + " = " + numerator[i]/denominator[i]);
				
			}catch (ArithmeticException | ArrayIndexOutOfBoundsException exc) {
				System.out.println("dividing by zero?? no match...? I don't know!");
				System.out.println("incrementing i to avoid a repeat of this failure! SOS");
				i = numerator.length;
				
			}
		}
	}

}
