import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;
import java.util.stream.Stream;


public class BackOnTheChainGang {
	public static void main(String args[]) throws keyNotFound{
		Scanner cin= new Scanner(System.in);
		String name;
		Scanner sInput=new Scanner(System.in);
		int input=0;
		
		HashMap<String, Integer> hashmaps= new HashMap<String, Integer>(509);
		try (Stream<String> stream = Files.lines(Paths.get("players_homeruns.csv"))) {
            stream
                .map(string -> string.split(",")) 
                .forEach(strArray -> hashmaps.insert(strArray[0],
                        Integer.parseInt(strArray[1])));
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		while(true){
			Menu();
			input=cin.nextInt();
			switch(input){
			case 1: System.out.print("Enter player name:");
			name=sInput.nextLine();
			System.out.println(name+" home runs:"+hashmaps.find(name));
			break;
			case 2: return;
			default: ;
			}
		}
	}
	public static void Menu(){
		System.out.println("\tMenu \n1.Check Player \n2.Exit");
		System.out.print("Enter Choice: \t");
	}
}