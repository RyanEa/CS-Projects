import java.util.TreeSet;
import java.util.Set;
import java.util.Random;
import java.util.Scanner;
public class LotteryProgram {
	public LotteryProgram(){
		Set<Integer> myticket=getTicket();
		Set<Integer> winning=generateWinningNumbers();
		System.out.println("The winning numbers are:"+winning.toString());
		System.out.println("Your numbers are:"+myticket.toString());
		Set<Integer>temp=myticket;
		temp.retainAll(winning);
		System.out.println("Matching #'s:"+temp.toString());
		//int matched=temp.size();
		if(temp.size()==0)
			System.out.println("You've won nothing.");
		else if(temp.size()==1)
			System.out.println("You've won $50!");
		else if(temp.size()==2)
			System.out.println("You've won $100!");
		else if(temp.size()==3)
			System.out.println("You've won $500!");
		else if(temp.size()==4)
			System.out.println("You've won $1000!");
		else if(temp.size()==5)
			System.out.println("You've won $5000!");
		else if(temp.size()==6)
			System.out.println("You've won $1,000,000!");
	}
	public static Set<Integer> generateWinningNumbers(){
		Set<Integer> winning = new TreeSet<Integer>();
		Random r = new Random();
		for (int i = 0; i < 6; i++) {
			int number = r.nextInt(10)+1;
			if (winning.contains(number)) {
				i--;
			}
			else{
			winning.add(number);
			}
		}
		return winning;
	}
	public static Set<Integer> getTicket( ){
		TreeSet<Integer> myticket = new TreeSet<Integer>();
		System.out.println("Enter 6 lotto numbers within 1-10");
		Scanner cin=new Scanner(System.in);
		for(int i=0;i<6;i++){
			int numbers=cin.nextInt();
			if(numbers<0 || numbers >10){
				System.out.println("Out of range.");
				i--;
			}
			else if(myticket.contains(numbers)){
				System.out.println("Enter again");
				i--;
			}
			else{
				myticket.add(numbers);
			}
		}
		return myticket;
	}
}
