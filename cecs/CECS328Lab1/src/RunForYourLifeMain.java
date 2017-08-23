import java.time.Duration;
import java.time.Instant;
import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;
 
public class RunForYourLifeMain {
	static RunForYourLife hello= new RunForYourLife();
	static int max;
	public static void main(String args[]){
		int inputsize, choice ,seed, upperb, lowerb;
		boolean exit=false;
		Scanner cin=new Scanner(System.in);
		System.out.print("Enter Seed:\t");
		seed=cin.nextInt();
		System.out.print("Enter input size:\t");
		inputsize=cin.nextInt();
		Random R= new Random(seed);
		int[] rng=R.ints(inputsize, -100, 101).toArray();
		while(!exit){
//			System.out.println(Arrays.toString(rng));
			Menu();
			System.out.println("Enter choice: \t");
			choice=cin.nextInt();
			max=0;
			switch(choice) {
			case 1: RunFreddyRun(rng);
				break;
			case 2: RunSusieRun(rng);
				break;
			case 3: RunJohnnyRun(rng);
				break;
			case 4: RunSallyRun(rng);
				break;
			case 5:
				System.out.print("Enter upper bound \t");
				upperb=cin.nextInt();
				System.out.print("Enter lower bound \t");
				lowerb=cin.nextInt();
				System.out.print("Enter seed \t");
				seed=cin.nextInt();
				System.out.print("Enter input size \t");
				inputsize=cin.nextInt();
				rng=R.ints(inputsize, lowerb, upperb+1).toArray();
				break;
			case 6: exit=true;
				break;
			default: ;
				break;
			}
		}
		System.out.println("END");
	}
	public static void Menu(){
		System.out.println("\t Menu \n1. Run Freddy's \n2. Run Susie's \n3. Run Johnny's \n4. Run Sally's"
				+ " \n5. Enter Test Values \n6. Exit");
	}
	public static void RunFreddyRun(int[] rng){
		Instant start = Instant.now();
		max= hello.Freddy(rng, rng.length);
		Instant end = Instant.now();
		System.out.println("Total execution time: "+ Duration.between(start, end).toMillis() + " miliseconds.  MAX="+ max);
	}
	public static void RunSusieRun(int[] rng){
		Instant start = Instant.now();
		max= hello.Susie(rng, rng.length);
		Instant end = Instant.now();
		System.out.println("Total execution time: "+ Duration.between(start, end).toMillis() + " miliseconds.  MAX="+ max);
	}
	public static void RunJohnnyRun(int[] rng){
		Instant start = Instant.now();
		max= hello.Johnny(rng, 0 ,rng.length -1);
		Instant end = Instant.now();
		System.out.println("Total execution time: "+ Duration.between(start, end).toMillis() + " miliseconds.  MAX="+ max);
	}
	public static void RunSallyRun(int[] rng){
		Instant start = Instant.now();
		max= hello.Sally(rng, rng.length);
		Instant end = Instant.now();
		System.out.println("Total execution time: "+ Duration.between(start, end).toMillis() + " miliseconds.  MAX="+ max);
	}
}
