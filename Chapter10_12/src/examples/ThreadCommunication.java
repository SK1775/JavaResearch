package examples;
class TickTock{
	String state;
	synchronized void tick(Boolean running) {
		if(!running) {
			state = "ticked";
			notify();
			return;
		}
		System.out.print("tick ");
		state = "ticked";
		
		notify();
		try {
			while(!state.equals("tocked")) {
				wait();
			}
		}catch(InterruptedException exc) {
			System.out.println("thread interrupted?");
		}
	}
	synchronized void tock(boolean running) {
		if(!running) {
			state = "tocked";
			notify();
			return;
		}
		System.out.println("tock");
		
		state = "tocked";
		
		notify();
		try {
			while(!state.equals("ticked")) {
				wait();
			}
		}catch(InterruptedException exc) {
			System.out.println("thread interrupted?");
		}
	}
}
class MyThread5 implements Runnable{
	Thread thrd;
	TickTock ttOb;
	
	MyThread5(String name, TickTock tt){
		thrd = new Thread(this, name);
		ttOb = tt;
	}
	public static MyThread5 createAndStart(String name, TickTock tt) {
		MyThread5 myThrd = new MyThread5(name, tt);
		myThrd.thrd.start();
		return myThrd;
	}
	public void run() {
		if(thrd.getName().compareTo("tick") == 0) {
			for(int i=0; i < 5; i++) {
				ttOb.tick(true);
			}
			ttOb.tick(false);
			
		}else {
			for(int i=0; i<5; i++) {
				ttOb.tock(true);
			}
			ttOb.tock(false);
		}
	}
}
	

public class ThreadCommunication {
	public static void main(String args[]) {
		TickTock tt = new TickTock();
		MyThread5 mt1 = MyThread5.createAndStart("tick", tt);
		MyThread5 mt2 = MyThread5.createAndStart("tock", tt);

		try {
			mt1.thrd.join();
			mt2.thrd.join();		
		}catch (InterruptedException exc) {
			System.out.println("main thread error");
		}
	}
}