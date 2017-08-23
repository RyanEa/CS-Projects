import java.util.Scanner;
import java.util.LinkedList;
public class RPNstacksAndqueues 
{
	public static void main(String[] args)
	{
		LinkedList stack=new LinkedList();
		String equation;
		String regex="\\d+$";
		StackAndQueue stacks=new StackAndQueue();
		Scanner input=new Scanner(System.in);
		System.out.println("Input an equation");
		equation=input.nextLine();
		equation=equation.concat("=");
		System.out.println(equation);
		String[] parts=equation.split("");
		for(int inc=1;inc<parts.length;inc++)
		{
			if(parts[inc].equals("(")||parts[inc].equals(")")||parts[inc].equals("+")||parts[inc].equals("-")||parts[inc].equals("*")||parts[inc].equals("/")||parts[inc].equals("=")||parts[inc].equals("^"))
			{
				stacks.add(" ");
				stacks.iadd(" ");
				stacks.iadd(parts[inc]);
				stacks.stack(parts[inc]);
			}
			else
			{
				if(parts[inc].matches(regex))
				{
				stacks.iadd(parts[inc]);
				stacks.add(parts[inc]);
				}
			}
		}
		stacks.display();
		stacks.solve();
	}
}