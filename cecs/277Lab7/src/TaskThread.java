import java.util.*;
public class TaskThread implements Runnable {
	private int taskNumber;
	TaskThread(int number) {
		taskNumber = number;
	}

	public void run() {
		for (int i=0;i<=100;i+=20) {
			// Perform some task ...
			System.out.println("Task number: " + taskNumber
					+ ", percent complete: " + i );
	try {
		Thread.sleep((int)(Math.random() * 1000));
	}
	catch (InterruptedException e)
	{}
		}//end for
	}//end main
}//end class