import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadTaskDemo {
	public static void main(String[] args){
		boolean what= true;
		ExecutorService thread1=Executors.newFixedThreadPool(2);
		for(int i=0;i<=3;i++){
			thread1.execute(new TaskThread(i));
		}
		thread1.shutdown();
	}
}
