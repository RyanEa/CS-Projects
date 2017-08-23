import java.util.Random;
public class Deck
{
	private int count;
	private Card[]data;
	//private Card[]temp=new Card[2];
	public Deck()
	{
		count=52;
		data=new Card[52];
	}
	public void create()
	{
		//int countup=0;
		int rank=1;
		int suit=1;
		for(int countup=0;countup<52;countup++)
		{
			data[countup]=new Card(rank,suit);
			if(rank<=13)
			{
				rank++;
				if(rank==14)
				{
					suit++;
					rank=1;
				}
			}
		}
	}

	public void display()
	{
		int start=0;
		while(start<count)
		{
			data[start].display();
			start++;	
		}
	}
	public void shuffle()
	{
		Card temp;
		int a,b;
		Random r=new Random();
		for(int i=0;i<count;i++)
		{
			a=r.nextInt(count);
			b=r.nextInt(count);
			temp=data[a];
			data[a]=data[b];
			data[b]=temp;
		}
	}
	public Card deal(int topdeck)
	{
		Card tempc;
		tempc=data[topdeck];
		data[--count]=null;
		return tempc;
	}
}