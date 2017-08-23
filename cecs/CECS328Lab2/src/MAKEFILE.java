import java.io.*;
import java.util.Arrays;
import java.util.Random;
public class MAKEFILE {
	public static void main(String args[]) throws IOException{
		DataOutputStream writed = new DataOutputStream(new FileOutputStream("english.bin"));
		writed.writeUTF("ONE");
		writed.writeUTF("TWO");
		writed.close();
		DataOutputStream write = new DataOutputStream(new FileOutputStream("sorted.bin"));
		write.writeInt(100000);
		for(int i=0; i<100000; i++){
			write.writeInt(i);
		}
		write.close();
		
		DataOutputStream writer = new DataOutputStream(new FileOutputStream("reverse.bin"));
		writer.writeInt(100000);
		for(int i=100000; i>0; i--){
			writer.writeInt(i);
		}
		writer.close();
		
		DataOutputStream writers = new DataOutputStream(new FileOutputStream("random.bin"));
		Random R= new Random(30);
		writers.writeInt(1000000);
		for(int i=0; i<1000000; i++){
			writers.writeInt(R.nextInt(10));
		}
		writer.close();		
		
		System.out.println("CLOSED");

		//READ CODE//
//		DataInputStream reader = new DataInputStream(new FileInputStream("Sorted.bin"));
//		int[] array= new int[reader.readInt()];
//		for(int i=0; i< array.length; i++)
//			array[i]=reader.readInt();
//		reader.close();
//		System.out.println("QUICK:"+Arrays.toString(array));
		//READ CODE//
		}
	}
