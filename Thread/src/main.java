import java.lang.reflect.Executable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class main {
	
	private static final int Numthreads = 4;
	
	public 	static  void main(String[] args){
		
		ExecutorService executor = Executors.newFixedThreadPool(Numthreads);		
		
		for(int i=0;i<Numthreads;i++){			
		executor.submit(new id(i));
		
		}
		
		executor.shutdown();
		try {
            Thread.sleep(2000);
         } catch (Exception ex) {
            System.out.println("All threads not finished.");
           
         }
		
	}

}	
