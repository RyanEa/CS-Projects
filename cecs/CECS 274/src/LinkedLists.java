import java.util.Random;
import java.util.Scanner;
public class LinkedLists 
{
	public static void main(String[] args)
	{
		Scanner input= new Scanner(System.in);
		int max;
		llist ones= new llist();
		System.out.println("List the amount of words to create between 15-240.");
		max=input.nextInt();
		String letter;
		while(max<15||max>240)
		{
			System.out.println("Input again.");
			max=input.nextInt();
		}
		for(int i=0;i<max;i++)
		{
			String a=strings();
			//System.out.println(a);
			ones.addinorder(a);
		}
			ones.displays();
			//menu();
			letter=menu();
			while(letter.equalsIgnoreCase("D")||letter.equalsIgnoreCase("A")||letter.equalsIgnoreCase("Q"))
			{
			if(letter.equalsIgnoreCase("D"))
			{
				System.out.println("Enter word to delete");
				String a=input.next();
				ones.delete(a);
				ones.displays();
				letter=menu();
				//letter=input.next();
			}
			else if(letter.equalsIgnoreCase("A"))
			{
				letter=strings();
				ones.addinorder(letter);
				ones.display2(letter);
				letter=menu();
			}
			else if(letter.equalsIgnoreCase("Q"))
			{
				System.exit(0);
			}
			}
	}
	public static String menu()
	{
		System.out.println("\n(A)dd    (D)elete    (Q)uit");
		Scanner input= new Scanner(System.in);
		String letter;
		boolean value=false;
		letter=input.next();
		while(value==false)
		{
		if(letter.equalsIgnoreCase("a")||letter.equalsIgnoreCase("d")||letter.equalsIgnoreCase("q"))
		{
			value=true;
		}
		else
		{
			System.out.println("Input again");
			letter=input.next();
		}
		}
		return letter;
	}
	public static String strings()
	{
		String jumble="";
		for(int i=0;i<=4;i++)
		{
			Random r=new Random();
			char rando=(char)(r.nextInt(26)+97);
			jumble=jumble+rando;
		}
		return jumble;
	}
}
