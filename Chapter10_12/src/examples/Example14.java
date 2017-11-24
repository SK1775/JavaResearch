package examples;

class MyThread2 implements Runnable{
	Thread thrd;
	
	MyThread2(String name){
		thrd = new Thread(this,name);
	}
	public static MyThread2 createAndStart(String name) {
		MyThread2 myThrd = new MyThread2(name);
		myThrd.thrd.start();
		return myThrd;
	}
	public void run() {
		System.out.println(thrd.getName() + " starting!");
		try {
			for(int count=0; count < 10; count++) {
				Thread.sleep(400);
				System.out.println("in " + thrd.getName() + ", count is " + count);
			}
		}catch(InterruptedException ecx) {
			System.out.println(thrd.getName() + " was interrupted");
		}
		System.out.println(thrd.getName() + " is done");
	}
}

public class Example14 {
	public static void main(String args[]) {
		System.out.println("main thread starting.");
		
		MyThread2 mt1 = MyThread2.createAndStart("child 1");
		MyThread2 mt2 = MyThread2.createAndStart("child 2");
		MyThread2 mt3 = MyThread2.createAndStart("child 3");
		
		for(int i=0; i < 50; i++) {
			System.out.print(".");
			try {
				Thread.sleep(100);
			}catch(InterruptedException exc) {
				System.out.println("main thread interrupted");
			}
		}
		System.out.println("main is ending");
		
	}
}
