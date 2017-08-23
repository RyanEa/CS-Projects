
public class llist
{
	private node head;
	public llist()
	{
		head=null;
	}
	public void display2(String word)
	{
		int list=0;
		boolean value=true;
		node tnode=head;
		while(tnode!=null)
		{
			if (list < 15) 
			{ 
				if(word.equalsIgnoreCase(tnode.getvalue())&&value==true)
				{
					System.out.print("*"+tnode.getvalue()+"\t");
					value=false;
				}
				else
				{
				System.out.print(tnode.getvalue()+"\t");
				}
				tnode=tnode.getnext();
				list++;
			}
			else
			{ 
				list=0;
				System.out.println("");
			}
		}
		head.count();
	}
	public void displays()
	{
		int list=0;
		node tnode=head;
		while(tnode!=null)
		{
			if (list < 15) 
			{ 
				System.out.print(tnode.getvalue()+"\t");
				tnode=tnode.getnext();
				list++;
			}
			else
			{ 
				list=0;
				System.out.println("");
			}
		}
		head.count();
	}
	public void delete(String word)
	{
		node nextnode=new node(word);
		node iterator=head;
		node prev=head;
		boolean value=false;
		if(iterator.getvalue().equalsIgnoreCase(nextnode.getvalue()))
		{
			head=head.getnext();
		}
		while(iterator!=null)
		{
			if(iterator!=null&&nextnode.getvalue().equalsIgnoreCase(iterator.getvalue()))
			{
				iterator=iterator.getnext();
				prev.setnext(iterator);
				value=true;
			}
			else
			{
			prev=iterator;
			iterator=iterator.getnext();
			}
		}
		if(iterator==null&&value==false)
		{
			System.out.println("Word not found.");
		}
	}
	public void addinorder(String word)
	{
		node nextnode=new node(word);
		node iterator=head;
		node prev=head;
		if(head==null)
			head=nextnode;
		else if(nextnode.getvalue().compareToIgnoreCase(iterator.getvalue()) < 0)
		{
			head=nextnode;
			nextnode.setnext(iterator);
		}
		else
		{
			 while(iterator!=null && nextnode.getvalue().compareToIgnoreCase(iterator.getvalue()) > 0)
			{
				prev=iterator;
				iterator=iterator.getnext();
			}
			prev.setnext(nextnode);
			nextnode.setnext(iterator);
		}
	}

	private class node
	{
		private String words;
		private node mynode;
		public node(String word)
		{
			mynode=null;
			words=word;
		}
		public String getvalue()
		{
			return words;
		}
		public void setnext(node anode)
		{
			mynode=anode;
		}
		public node getnext()
		{
			return mynode;
		}
		public void count()
		{
			int counter=0;
			node count=head;
			while(count!=null)
			{
				counter++;
				count=count.getnext();
			}
			System.out.print("\n"+counter+" words in the list.");
		}
	}
}
