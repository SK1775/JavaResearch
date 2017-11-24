package examples;

class MyThread implements Runnable{
	String thrdName;
	MyThread(String name){
		thrdName = name;
	}
	
	public void run() { // thread starts here and must define run as it inherits it as an abstract method
		System.out.println(thrdName + " starting");
		try {
			for(int i=0; i<5; i++) {
				Thread.sleep(400);
				System.out.println("In " + thrdName + ", count is " + i);
			}
		}catch(InterruptedException exc) {
			System.out.println(thrdName + " interrupted");
			System.out.println(thrdName + " ending");
		}
	}
}

public class Example12 {
	public static void main(String args[]) {
		System.out.println("main thread starting.");
		MyThread mt = new MyThread("child thread #1"); //creating runnable object
		Thread newThread = new Thread(mt); //construct a thread from that object
		
		newThread.start();
		
		for(int i=0; i<50; i++) {
			System.out.print(".");
			try {
				Thread.sleep(11);
			}catch(InterruptedException exc) {
					System.out.println("Main thread interrupted.");
			}
		}
		System.out.println("main thread is done");
	}
}
