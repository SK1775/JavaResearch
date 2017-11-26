package multithreading;
import java.util.concurrent.ThreadLocalRandom;

class MyThread implements Runnable{
	Thread thread;
	int id;
	
	MyThread(String name, int id){
		thread = new Thread(this, name);
		this.id = id;
	}
	
	public static MyThread tStart(String name, int id) {
		MyThread mythread = new MyThread(name, id);
		mythread.thread.start();
		return mythread;
	}

	public void run() {
		//System.out.println( this.getID() );
	}
	public void sayHi() {
		System.out.println("Hello from " + id);
	}
	
	public int getID() {
		return id;
	}
	
	void updateMatrix(int oldMatrix[][], int newMatrix[][]){
        int i,j,sum;
        int len = oldMatrix.length;
        int lim = ((len-2) / 4) + 1;
        int end = id*lim+4;
        
        if(end >= len) {
        	end = len-1;
        }
        
        for(i = lim*id+1; i < end ; i++){
            for(j = 1; j < len-1; j++){              	
                sum = oldMatrix[i-1][j-1]+oldMatrix[i-1][j]+oldMatrix[i-1][j+1]+
                       oldMatrix[i][j-1]+oldMatrix[i][j]+oldMatrix[i][j+1]+
                       oldMatrix[i+1][j-1]+oldMatrix[i+1][j]+oldMatrix[i+1][j+1];

                if(sum % 10 == 0){
                	newMatrix[i][j] = 0; 
                } else if(sum < 50) {
                	newMatrix[i][j] = oldMatrix[i][j] + 3;  
                } else if(50 < sum && sum < 150) {
                	newMatrix[i][j] = oldMatrix[i][j] - 3 ;
                	if(newMatrix[i][j] < 0) {
                	 newMatrix[i][j] = 0;    
                	}
                }else if(sum > 150){
                	newMatrix[i][j] = 1;
                }
            }
        }

	}
}

public class MatrixFun {
	public static void main(String args[]) {
		int size=0, iterations=0;
		
		if(args.length == 2) {
			size = Integer.parseInt(args[0]);
			if(size < 7) {
				System.out.println("Size must be 8 or larger");
				System.exit(0);
			}
			iterations = Integer.parseInt(args[1]);
			System.out.println("size: " + size + "  its: " + iterations);
		}else {
			System.out.println("<java> <size_of_arrays> <iterations>");
			System.exit(0);
		}
		

		//int randomNum = ThreadLocalRandom.current().nextInt(5, 50 + 1);
		int a_array[][] = new int[size][size];
		int b_array[][] = new int[size][size];
		
		for(int i=0; i < size; i++) {
			for(int j=0; j < size; j++) {
				if(i == 0 || j == 0 || j == size-1 || i == size-1) {
					a_array[i][j] = 0;
				}else {
					a_array[i][j] = ThreadLocalRandom.current().nextInt(5, 25 + 1);
				}				
			}
		}
		for(int i=0; i < size; i++) {
			for(int j=0; j < size; j++) {
				System.out.print(a_array[i][j] + "\t");		
			}System.out.println();
		}

		MyThread t1 = MyThread.tStart("zero", 0);
		MyThread t2 = MyThread.tStart("one", 1);
		MyThread t3 = MyThread.tStart("two", 2);
		MyThread t4 = MyThread.tStart("three", 3);
		
		int its = 0;
		while(its < iterations) {
			if(its % 2 == 0) {
				t1.updateMatrix(a_array, b_array);
				t2.updateMatrix(a_array, b_array);
				t3.updateMatrix(a_array, b_array);
				t4.updateMatrix(a_array, b_array);
						
				System.out.println();
				
				for(int i=0; i < size; i++) {
					for(int j=0; j < size; j++) {
						System.out.print(b_array[i][j] + "\t");		
					}System.out.println();
				}
			}else {
				t1.updateMatrix(b_array, a_array);
				t2.updateMatrix(b_array, a_array);
				t3.updateMatrix(b_array, a_array);
				t4.updateMatrix(b_array, a_array);
						
				System.out.println();
				
				for(int i=0; i < size; i++) {
					for(int j=0; j < size; j++) {
						System.out.print(a_array[i][j] + "\t");		
					}System.out.println();
				}				
				
			}
					
			its++;
		}
	}
	
}
