import java.util.*;
public class hand 
{
	private Card[]hand;
	private int count;
	private int bank;
	private int max;
	private int bets;
	int ace=0;
	int total=0;
	public hand(int hmax)
	{
		bank=10;
		max=hmax;
		count=0;
		hand=new Card[hmax];
	}
	public void draw(int position,Card recieve)
	{
		hand[position]=recieve;
	}
	public void displays(int current, boolean dealer)
	{
		int x=0;
		for(;x<=current;x++)
		{
			if(dealer==true&&x==0)
				System.out.println("????? ?? ??????");
			else if(dealer==true&&x!=0)
			{
			hand[x].display();
			}
			else
			hand[x].display();
		}
	}
	public int value(int hposition)
	{
		if(hposition==0)
		{
			total=0;
		}
		String temp;
		StringTokenizer part= new StringTokenizer(hand[hposition].displayvalue());
		temp=part.nextToken(" ");
			if(temp.equals("Ace"))
				ace=1;
			else if(temp.equals("2"))
				total=2+total;
			else if(temp.equals("3"))
				total=3+total;
			else if(temp.equals("4"))
				total=4+total;
			else if(temp.equals("5"))
				total=5+total;
			else if(temp.equals("6"))
				total=6+total;
			else if(temp.equals("7"))
				total=7+total;
			else if(temp.equals("8"))
				total=8+total;
			else if(temp.equals("9"))
				total=9+total;
			else if(temp.equals("10"))
				total=10+total;
			else if(temp.equals("Jack"))
				total=10+total;
			else if(temp.equals("Queen"))
				total=10+total;
			else if(temp.equals("King"))
				total=10+total;
		if(total<21)
		{
			if(ace==1)
			{
				total=total+11;
				if(total>21)
					total=total-10;
			}		
		}
		else if(total>21)
		{
			if(ace==1)
			{
				total=total+11;
				if(total>21)
					total=total-10;
			}
		}
		return total;
	}
	public int bettingup()
	{
			Scanner bet=new Scanner(System.in);
			System.out.print("How much do you want to bet?");
			System.out.println("(Current Money:"+bank+(")"));
			bets=bet.nextInt();
			while(bets>bank)
			{
				//if(bets>bank)
					System.out.println("Not enough money...");
				bets=bet.nextInt();
			}
			bank=bank-bets;
			return bank;
	}
	public void winnings(char result)
	{
		if(result=='t')
		{
			bank=bank+bets;
			ace=0;			
		}
		else if(result=='w')
		{
			bank=bank+(2*bets);
			ace=0;
		}
		else if(result=='l')
			ace=0;
			
		System.out.println("You have "+bank+" dollars");
		total=0;
	}
}