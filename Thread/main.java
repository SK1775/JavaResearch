import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;




public class main {
	
	private static final int Numthreads = 3;
	
	public 	static  void main(String[] args){
		
		ExecutorService executor = Executors.newFixedThreadPool(Numthreads);
		
		
		for(int i=0;i<Numthreads *2;i++){			
		executor.submit(new id(i));
		
		}
		
		executor.shutdown();
		
	}

}
