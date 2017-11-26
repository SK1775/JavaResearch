
public class id implements Runnable{
	
	private int thrd;
	private int num;
	
	public id(int thrd){
		this.thrd= thrd;
		
	}
	
	 public void run()
	{	 	 
		 for (int i = 0; i <3; i++) {
	         try {
	            System.out.println("Thread ID: " +
	               thrd + " Iteration No: " + i);
	            Thread.sleep(2000);
	         } catch (Exception ex) {
	            System.out.println("Task ID: " +
	               thrd + " is interrupted.");
	            break;
	         }
	      }
	   }

}


