package examples;
class SumArray{
	private int sum;
	synchronized int sumArray(int nums[]) {
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

class MyThread3 implements Runnable{
	Thread thrd;
	static SumArray sa = new SumArray();
	int a[];
	int answer;
	
	MyThread3(String name, int nums[]){
		thrd = new Thread(this, name);
		a = nums;
	}
	public static MyThread3 createAndStart(String name, int nums[]) {
		MyThread3 myThrd = new MyThread3(name, nums);
		myThrd.thrd.start();
		return myThrd;
	}
	public void run() {
		int sum;
			System.out.println(thrd.getName() + " starting.");
			answer = sa.sumArray(a);
			System.out.println("Sum for " + thrd.getName() + " is " + answer);
			System.out.println(thrd.getName() + " is done");
	}
}
public class Synchronized {
	public static void main(String args[]) {
		int a[] = {1,2,3,4,5};
		MyThread3 mt1 = MyThread3.createAndStart("child #1", a);
		MyThread3 mt2 = MyThread3.createAndStart("child #2", a);
				
		try {
			mt1.thrd.join();
			mt2.thrd.join();
		}catch(InterruptedException exc) {
			System.out.println("thread interrupted, main");
		}
	}
}
