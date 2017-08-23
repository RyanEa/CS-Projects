import java.util.*;
public class Card 
{
	private String title;
	private int rank;
	private int suit;
	int total=0;int ace=0;
	public Card(int r, int s)
	{
		rank=r; 
		suit=s;
		switch(rank)
		{
		case 1:title=("Ace of ");
		break;
		case 2:title=("2 of ");
		break;
		case 3:title=("3 of ");
		break;
		case 4:title=("4 of ");
		break;
		case 5:title=("5 of ");
		break;
		case 6:title=("6 of ");
		break;
		case 7:title=("7 of ");
		break;
		case 8:title=("8 of ");
		break;
		case 9:title=("9 of ");
		break;
		case 10:title=("10 of ");
		break;
		case 11:title=("Jack of ");
		break;
		case 12:title=("Queen of ");
		break;
		case 13:title=("King of ");
		break;
		}
		switch(suit)
		{
		case 1:title=title.concat("Hearts");
		break;
		case 2:title=title.concat("Spades");
		break;
		case 3:title=title.concat("Diamonds");
		break;
		case 4:title=title.concat("Clubs");
		break;
		}
	}
	public void display()
	{
		System.out.println(title);	
	}
	public String displayvalue()
	{
		return title;
	}
}
