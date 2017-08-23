import java.util.Scanner;
public class BSTinput 
{
	public static void main(String[] args)
	{
		BinarySearchTree bst=new BinarySearchTree();
		Scanner input=new Scanner(System.in);
		int insert;
		int num;
		int total;
		Menu();
		num=input.nextInt();
		while(num>0||num<=0)
		{
			if(num==1)
			{
				System.out.println("Enter how many numbers to insert into the tree.");
				total=input.nextInt();
		for(int x=0;x<total;x++)
		{
			System.out.println("Value#"+(x+1));
			insert=input.nextInt();
			bst.add(insert);
		}
		Menu();
		num=input.nextInt();
			}
			if(num==2)
			{
				bst.delete();
				Menu();
				num=input.nextInt();
			}
			if(num==3)
			{
				bst.find();
				Menu();
				num=input.nextInt();
			}
			if(num==4)
			{
				bst.balance();
				Menu();
				num=input.nextInt();
			}
			if(num==5)
			{
				bst.Display();
				Menu();
				num=input.nextInt();
			}
			if(num==6)
			{
				bst.stats();
				Menu();
				num=input.nextInt();
			}
			if(num==0)
			{
				System.exit(0);
				Menu();
				num=input.nextInt();
			}
		}
	}
	public static void Menu()
	{
		System.out.println("\t Binary Search Tree");
		System.out.println("1.Add");
		System.out.println("2.Delete");
		System.out.println("3.Find");
		System.out.println("4.Balance");
		System.out.println("5.List Contents");
		System.out.println("6.Statistics");
		System.out.println("0.Exit");
	}
}
