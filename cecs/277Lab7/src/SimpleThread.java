
public class SimpleThread extends Thread {
	String message;
	public SimpleThread(String temp){
		message=temp;
	}
	public void run() {
		for(int i=0; i<=10; i++){
			if(i<=9){
			System.out.println(i + message);
			}
			if(i==10){
				System.out.println("DONE!"+ message);
			}
			try {
				this.sleep((int)(Math.random() * 500));
			}
			catch (InterruptedException e)
			{
			}
		}
	}
}
