import java.io.*;
import java.time.Duration;
import java.time.Instant;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Random;
public class OutOfSorts {
	public static void main(String args[]) throws IOException{
		Scanner cin= new Scanner(System.in);
		int input;
		String file;
		while(true){
		Menu();
		input= cin.nextInt();
		switch (input) {
		case 1:file="reverse.bin";
			System.out.println("RUNNING:"+file);
			ReadAndSort(file);
			break;
		case 2:
			file="sorted.bin";
			System.out.println("RUNNING:"+file);
			ReadAndSort(file);
			break;
		case 3:
			file="random.bin";
			System.out.println("RUNNING:"+file);
			ReadAndSort(file);
			break;
		case 4:
			System.exit(0);
			break;
		default:
			break;
		}
		}
	}
	public static void isort(int[] array, int begin, int ended){
		for(int i=begin+1; i< ended; i++){
			int j, temp=array[i];
			for(j=i-1;j >= begin; j--){
				if(array[j] >= temp)
					array[j+1]= array[j];
				else
					break;
			}
			array[j+1]=temp;
		}
	}
	public static int Pivot(int[] array, int begin, int last){
		if ((array[begin] > array[last] && array[(begin+(last-begin)/2)] > array[begin]) || (array[begin]< array[last] &&
				array[(begin+(last-begin)/2)] < array[begin])){
			return begin;
		}
		else if((array[begin] > array[last] && array[last] > array[(begin+(last-begin)/2)]) || (array[begin] < array[last] &&
				array[last] < array[(begin+(last-begin)/2)])){
			return last;
		}
		else {
			return (begin+(last-begin)/2);
		}	
	}
	public static int Partition(int[] array, int begin, int last){
		int x,pivot;
		x=Pivot(array, begin, last);
		pivot= array[x];
		array[x]=array[last];
		array[last]=pivot;
		int svalue=array[begin];
		int s=begin;
		for(int i= begin; i<last; i++){
			if(array[i]< pivot){
				array[s]=array[i];
				array[i]=svalue;
				s++;
				svalue=array[s];
			}
		}
		int temp= array[last];
		array[last]=array[s];
		array[s]=temp;
		return s;
	}
	public static void qsort(int[] array, int begin, int last){
		if(begin >= last)
			return;
		if(last-begin <= 4){
			isort(array, begin, last+1);
			return;
		}
		int s = Partition(array, begin, last);
		qsort(array, begin ,s-1);//left
		qsort(array, s+1,last);//right
	}
	public static void Menu(){
		System.out.println("\tMENU \n1. Reverse.bin \n2. Sorted.bin \n3. Random.bin \n4. Quit");
	}
	public static void ReadAndSort(String filename) throws IOException{
		DataInputStream reader = new DataInputStream(new FileInputStream(filename));
		int[] array= new int[reader.readInt()];
		for(int i=0; i< array.length; i++)
			array[i]=reader.readInt();
		reader.close();
		//System.out.println("Original:\n"+Arrays.toString(array));
		runQSort(array);
		runISort(array);	
	}
	public static void runQSort(int[] original){
		int[] qsorts= Arrays.copyOf(original, original.length);
		Instant start2 = Instant.now();
		qsort(qsorts, 0, qsorts.length-1);
		Instant end2 = Instant.now();
		System.out.println("QUICK:\n"+Arrays.toString(qsorts));
		System.out.println("Total execution time:Quicksort "+ Duration.between(start2, end2).toMillis() + " miliseconds.");
	}
	public static void runISort(int[] original){
		int[] isorts= Arrays.copyOf(original, original.length);
		Instant start = Instant.now();
		isort(isorts, 0, isorts.length);
		Instant end = Instant.now();
		System.out.println("INSERTION:\n"+Arrays.toString(isorts));
		System.out.println("Total execution time:InsertionSort "+ Duration.between(start, end).toMillis() + " miliseconds.");

	}
}
