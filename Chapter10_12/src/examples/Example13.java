package examples;

/*	
 * 	MyThread variations.  This version of mythread creates
 *  a Thread when its constructor is called
 * 	and stores it in an instance variable called thrd.
 * 	It also sets the name of the thread and provides
 * 	a factory method to create and start a thread.
 */
class MyThread1 implements Runnable{
	Thread thrd; //reference to a Thread object
	MyThread1(String name){
		thrd = new Thread(this, name);  // thread is named when its created;
	}
	public static MyThread1 createAndStart(String name) {
		MyThread1 myThrd = new MyThread1(name);
		myThrd.thrd.start();
		return myThrd;
	}
	public void run() {
		System.out.println(thrd.getName() + " starting.");
		try {
			for(int count=0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("In " + thrd.getName() + ", count is " + count);
			}
		}catch(InterruptedException exc) {
			System.out.println(thrd.getName() + " interrupted");
		}
		System.out.println(thrd.getName() + " terminating");
		
	}
}
public class Example13 {
	public static void main(String args[]) {
		System.out.println("main starting");
		MyThread1 mt = MyThread1.createAndStart("child #1");
		
		for(int i=0; i < 10; i++) {
			System.out.print(".");
			try {
				Thread.sleep(100);
			}catch(InterruptedException exc){
				System.out.println("Main was intterupted.");
			}
			
		}
		System.out.println("main is ending.");
	}
}
