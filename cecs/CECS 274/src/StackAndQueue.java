import java.util.LinkedList;
import java.util.ArrayList;
public class StackAndQueue
{
	public LinkedList stack1=new LinkedList();
	public String rpne="";
	public String infix="";
	public int counter=0;
	public static ArrayList<Integer> mystack=new ArrayList<Integer>();
	public void stack(String partss)
	{
		int value=0;
		int svalue=0;
		if(partss.equals("("))
			value=1;
		else if(partss.equals(")"))
			svalue=7;
		else if(partss.equals("+"))
			svalue=1;
		else if(partss.equals("-"))
			svalue=1;
		else if(partss.equals("/"))
			svalue=2;
		else if(partss.equals("*"))
			svalue=2;
		else if(partss.equals("^"))
			svalue=3;
		if(mystack.isEmpty()==true)
		{
			mystack.add(svalue);
			stack1.add(partss);
		}
		else if(value==1)
		{
			mystack.add(svalue);
			stack1.add(partss);
		}
		else if(svalue==7)
		{
			while(mystack.get(mystack.size()-1)!=0&&mystack.isEmpty()==false)
			{
				add(stack1.get(stack1.size()-1).toString().concat(" "));
				mystack.remove(mystack.size()-1);
				stack1.removeLast();
			}
			mystack.remove(mystack.size()-1);
			stack1.removeLast();
		}
		else if(mystack.get(mystack.size()-1)>=svalue)
		{
			while(mystack.isEmpty()==false&&mystack.get(mystack.size()-1)!=0&&mystack.get(mystack.size()-1)>=svalue==true)
			{
				add(stack1.get(stack1.size()-1).toString().concat(" "));
				mystack.remove(mystack.size()-1);
				stack1.removeLast();
			}
			mystack.add(svalue);
			stack1.add(partss);
		}
		else if(mystack.get(mystack.size()-1)<svalue)
		{
			mystack.add(svalue);
			stack1.add(partss);
		}
		if(partss.equals("="))
		{
			while(mystack.isEmpty()==false)
			{
				if(stack1.get(stack1.size()-1).toString().equals("=")==false)
				{
					add(stack1.get(stack1.size()-1).toString().concat(" "));
				}
				stack1.removeLast();
				mystack.remove(mystack.size()-1);
			}
		}
	}
	public String add(String concats)
	{
		return rpne=rpne.concat(concats);
	}
	public String iadd(String concats)
	{
		return infix=infix.concat(concats);
	}
	public void display()
	{
		String[] broken=rpne.split(" ");
		String[] ibroken=infix.split(" ");
		System.out.println("RPNE:");
		for(int i=0;i<broken.length;i++)
		{
			System.out.print(broken[i]+" ");
		}
		System.out.println("\nREGULAR EQUATION:");
		for(int i=0;i<ibroken.length;i++)
		{
			System.out.print(ibroken[i]);
		}
		System.out.println("\n");
	}
	public double solve()
	{
		double total=0;double value;
		String[] ibroken=rpne.split(" ");
		String regex="\\d+$";
		String regex2="[+-/*^]";
		for(int count=0;count<ibroken.length;count++)
		{
		if(ibroken[count].matches(regex))
			{
				double number=Double.parseDouble(ibroken[count]);
				stack1.push(number);
			}
		else if(ibroken[count].matches(regex2))
		{
			if(ibroken[count].equals("+"))
			{
				double a=(double) stack1.pop();
				double b=(double) stack1.pop();
				value=a+b;
				stack1.push(value);
			}
			else if(ibroken[count].equals("-"))
			{
				double a=(double) stack1.pop();
				double b=(double) stack1.pop();
				value=b-a;
				stack1.push(value);
			}
			else if(ibroken[count].equals("/"))
			{
				double a=(double) stack1.pop();
				double b=(double) stack1.pop();
				value=b/a;
				stack1.push(value);
			}
			else if(ibroken[count].equals("*"))
			{
				double a=(double) stack1.pop();
				double b=(double) stack1.pop();
				value=b*a;
				stack1.push(value);
			}
			else if(ibroken[count].equals("^"))
			{
				double a=(double) stack1.pop();
				double b=(double) stack1.pop();
				value=Math.pow(b,a);
				stack1.push(value);
			}
		}
		}
		total=(double) stack1.pop();
		System.out.println(total);
		return total;
	}
}
