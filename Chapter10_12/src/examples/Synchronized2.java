package examples;
class SumArray2{
	private int sum;
	int SumArray2(int nums[]) { //no longer synchronized!
		sum = 0;
		for(int i=0; i < nums.length; i++) {
			sum += nums[i];
			System.out.println("running total for " + Thread.currentThread().getName() + " is " + sum);
			try {
				Thread.sleep(10);;
			}catch(InterruptedException exc) {
				System.out.println("Thread interrupted");
			}
		}
		return sum;
	}
}

class MyThread4 implements Runnable{
	Thread thrd;
	static SumArray2 sa = new SumArray2();
	int a[];
	int answer;
	
	MyThread4(String name, int nums[]){
		thrd = new Thread(this, name);
		a = nums;
	}
	public static MyThread4 createAndStart(String name, int nums[]) {
		MyThread4 myThrd = new MyThread4(name, nums);
		myThrd.thrd.start();
		return myThrd;
	}
	public void run() {
		int sum;
			System.out.println(thrd.getName() + " starting.");
			synchronized(sa) { //synchronize an object
				answer = sa.SumArray2(a);
			}
			System.out.println("Sum for " + thrd.getName() + " is " + answer);
			System.out.println(thrd.getName() + " is done");
	}
}
public class Synchronized2 {
	public static void main(String args[]) {
		int a[] = {1,2,3,4,5};
		MyThread4 mt1 = MyThread4.createAndStart("child #1", a);
		MyThread4 mt2 = MyThread4.createAndStart("child #2", a);
				
		try {
			mt1.thrd.join();
			mt2.thrd.join();
		}catch(InterruptedException exc) {
			System.out.println("thread interrupted, main");
		}
	}
}
