import java.util.*;
public class Blackjack 
{
	public static void main(String[] args)
	{
		int choice;     
		Scanner input= new Scanner(System.in);
		Deck mydeck=new Deck();//Creates a new deck
		hand myhand=new hand(11);//Creates a new player hand 
		hand dhand=new hand(11);//creates a new dealer hand
		int ctotal=51;
		Blackjacks();
		choice=input.nextInt();
		while(choice>0||choice<6)
			{
		if(choice==1)
		{
			mydeck.create();//Creates a brand new deck
			Blackjacks();
			ctotal=51;
			choice=input.nextInt();
		}
		else if(choice==2)
		{
			mydeck.shuffle();
			Blackjacks();
			choice=input.nextInt();
		}
		else if(choice==3)
		{
			mydeck.display();
			Blackjacks();
			choice=input.nextInt();
		}
		else if(choice==4)
		{
			if(ctotal>0)//Check for total # of cards
		{
			String play="";
			do//If person plays again
			{
			Scanner hit=new Scanner(System.in);
			Scanner hits=new Scanner(System.in);
			String stand="h";
			int phtotal=0;
			int dhtotal=0;
			int deal=0;int increase=1;
			int ddeal=0;int dincrease=1;
			boolean dealers=true;
			boolean continues=true;
			int money=myhand.bettingup();
			System.out.println("Dealer's hand: ");
			for(;ddeal<=dincrease;ddeal++)
			{
				dhand.draw(ddeal,mydeck.deal(ctotal--));
				dhtotal=dhand.value(ddeal);
			}
			System.out.println(dhtotal);
			dhand.displays(dincrease, dealers=true);
			System.out.print("\nYour hand: ");
			for(;deal<=increase;deal++)
				{
					myhand.draw(deal,mydeck.deal(ctotal--));
					phtotal=myhand.value(deal);
					if(phtotal>21)
						continues=false;
				}
			System.out.println(phtotal);
			myhand.displays(increase, dealers=false);
			while(continues==true)
			{
			System.out.println("Type H to hit and any other button to continue.");
			stand=hit.next();
			if(phtotal<21&&stand.equalsIgnoreCase("H"))//Player's hand calculations
			{
				myhand.draw(deal,mydeck.deal(ctotal--));
				phtotal=myhand.value(deal);
				myhand.displays(deal, dealers=false);
				deal++;
				System.out.println("Value= "+phtotal);
				if(phtotal>=21)
					break;
			}
			else {continues=false;}
			
			}
			continues=true;
			if(dhtotal<17)//Dealer's hand calculations
			{
				dhand.draw(ddeal,mydeck.deal(ctotal--));
				dhtotal=dhand.value(ddeal);
				ddeal++;
			}
			System.out.println("\nYour hand:"+phtotal);
			myhand.displays(deal-1, dealers=false);
			System.out.println("Dealer's hand:"+dhtotal);
			dhand.displays(ddeal-1, dealers=false);
			char wins='x';
			if(dhtotal==21&&phtotal==21)
			{
				System.out.println("Tie");
				wins='t';
			}
			else if(phtotal==dhtotal)
			{
				System.out.println("Tie");
				wins='t';
			}
			else if(phtotal<21&&dhtotal<21)
			{
				if(21-phtotal<21-dhtotal)
				{
				System.out.println("Win");
				wins='w';
				}
				else
				{
					System.out.println("You lose");
					wins='l';	
				}
			}
			else if(phtotal==21)
			{
				System.out.println("Win");
				wins='w';
			}
			else if(phtotal>21)
			{
				System.out.println("You lose");
				wins='l';
			}
			else if(phtotal<21&&dhtotal>21)
			{
				System.out.println("You win");
				wins='w';
			}
			myhand.winnings(wins);
			if(money==0)
			{
				System.out.println("No money left...");
				break;
			}
			System.out.println("Play again? Enter y to play again.");
			play=hits.next();			
		}while(play.equalsIgnoreCase("y"));
		}
			else 
			{
				System.out.println("Make a new deck.");
			}
			Blackjacks();
			choice=input.nextInt();
		}
		else if(choice==5)
			System.exit(0);
			}
	}	
	public static void Blackjacks()
	{
		System.out.println("\t The Game of Blackjack");
		System.out.println("1. New Deck\n");
		System.out.println("2. Shuffle cards in deck\n");
		System.out.println("3. Display all cards remaining in the deck\n");
		System.out.println("4. Play Blackjack\n");
		System.out.println("5. Exit Blackjack\n");
	}
}
