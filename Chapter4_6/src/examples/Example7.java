package examples;

public class Example7 {
	public static void main(String args[]) {
		/*	built in string methods
		 * 		boolean equals(str)   	returns true if both strings are complete matches at ever index
		 * 		int length				returns an int of the number of chars in string
		 * 		char charAt(index)		returns the character at index
		 * 		int compareTo(str)		returns less than 0 if invoking string is less str, greater than 0 if it is more than str and 0 if they're equal
		 * 		int indexOf(str)		returns first index of string or -1 if it doesn't exist
		 * 		int lastindexof(str)	returns last index of string or -1 if it doesn't exist
		 * 		boolean ==				whether the stings are the same string, stored at the same memory location
		 */
		
		int x = 0;
		
		System.out.println("there are " + args.length + " cmd line arguments");
		System.out.println("they are: ");
		for(int i=0; i < args.length; i++) {
			System.out.print("arg[" + i + "]: " + args[i] + "  ");
			
		}
	}

}
