package examples;

public class UseMain {
	public static void main(String args[]) {
		Thread thrd;
		thrd = Thread.currentThread();
		
		System.out.println("Main thread is called: " + thrd.getName());
		
		System.out.println();
		
		System.out.println("Setting name and priority of main!\n");
		thrd.setName("My awesome thread");
		thrd.setPriority(Thread.NORM_PRIORITY+3);

		System.out.println("Main thread is called: [" + thrd.getName() + "] and it is now priority " + thrd.getPriority());
	}
}
