import java.util.Scanner;
import java.util.ArrayList;
public class HappyNumbers 
{
	public static ArrayList<Integer> aList;
	public static int count=0;
	public static boolean verdict=true;
	public static void main(String[] args)
	{
		aList=new ArrayList<Integer>();
		Scanner input=new Scanner(System.in);
		int fvalue;
		boolean passvalue;
		System.out.println("Input a positive value");
		fvalue=input.nextInt();
		while(fvalue<0)
		{
			System.out.println("Input again");
			fvalue=input.nextInt();
		}
		while(fvalue>0)
		{
		passvalue=happyNum(fvalue);
		if(passvalue==true)
		{
			int cup=0;
			while(cup<aList.size())
			{
				System.out.print(aList.get(cup)+" , ");
				cup++;
			}
			System.out.println("\n"+fvalue+" is a happy number.");
			aList.clear();count=0;
			System.out.println("Input another number to continue. Enter 0 to exit");
			fvalue=input.nextInt();
			if(fvalue==0)
				System.exit(0);
		}
		else if(passvalue==false)
		{

			int cup=0;
			while(cup<aList.size())
			{
				System.out.print(aList.get(cup)+" , ");
				cup++;
			}
			System.out.println("\n"+fvalue+" is not a happy number.");
			aList.clear();count=0;
			System.out.println("Input another number to continue. Enter 0 to exit");
			fvalue=input.nextInt();
			if(fvalue==0)
				System.exit(0);
		}
		}
	}
	public static boolean happyNum(int num)
	{
		int value;
		int evalue=num;
		int total=0;
		while(num!=0)
		{
			value=num%10;
			total=total+value*value;
			num=num/10;
		}
		aList.add(total);
		count++;
		if(total==1)
		{
			verdict=true;
			return verdict;
		}
		if(total!=1)
		{
			for(int up=0;up<count-1;up++)
				{
				if(total==aList.get(up))
				{
					verdict=false;
					return verdict;
				}
				}
			happyNum(total);
		}
		return verdict;
	}
}