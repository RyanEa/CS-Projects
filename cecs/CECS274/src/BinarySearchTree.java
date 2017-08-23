import java.util.*;
public class BinarySearchTree 
{
	private node root;
	private boolean founded=false;
	private ArrayList<Integer>iolist=new ArrayList<Integer>();
	private boolean iftrue=false;
	private int level=0;
	public BinarySearchTree()
	{
		root=null;
	}
	public void add(int numb)
	{
		node addnode=new node(numb);
		node traverse=root;
		if(root==null)
		{
			root=addnode;
		}
		else if(root!=null)
		{
		while(traverse.lgetnext()!=null||traverse.rgetnext()!=null)
			{
				if(addnode.getvalue()>traverse.getvalue())
				{
					if(traverse.rgetnext()==null)
					{
						break;
					}
					traverse=traverse.rgetnext();
				}
				else if(addnode.getvalue()<traverse.getvalue())
				{
					if(traverse.lgetnext()==null)
					{
						break;
					}
					traverse=traverse.lgetnext();
				}
			}
		if(addnode.getvalue()>traverse.getvalue())
			traverse.rsetnext(addnode);
		else if(addnode.getvalue()<traverse.getvalue())
			traverse.lsetnext(addnode);
		}
	}
	public void delete()
	{
		node delete=root;
		iolist.clear();
		createarray(delete);
		System.out.println("Input a number to delete.");
		Scanner inputs=new Scanner(System.in);
		int del;
		del=inputs.nextInt();
		if(iolist.indexOf(del)!=-1)
		{
		node repeat=root;
		replace(iolist.get(iolist.indexOf(del)),repeat);
		}
		else
			System.out.println("Number not found");
	}
	public void Delete(int target)
	{
		node prev=root;
		node move=root;
		while(move.lgetnext()!=null&&move.lgetnext().getvalue()!=target||move.rgetnext()!=null&&move.rgetnext().getvalue()!=target)
		{
		if(target>move.getvalue())
		{
			move=move.rgetnext();
			prev=prev.rgetnext();
		}
		else
		{
			move=move.lgetnext();
			prev=prev.lgetnext();
		}
		}
		if(move.lgetnext()!=null&&move.lgetnext().getvalue()==target)
		{
			move=move.lgetnext();
			if(move.rgetnext()==null)
			{
				if(move.lgetnext().rgetnext()!=null)
				{
				move=move.lgetnext();
				prev.lsetnext(move);
				}
			}
			else
			{
				prev=prev.lgetnext();
				while(move.rgetnext().rgetnext()!=null)
					move=move.rgetnext();
				int temp=move.rgetnext().getvalue();
				prev.svalue(temp);
				System.out.println("Temp."+temp);
				move.rsetnext(null);
			}
		}
		else if(move.rgetnext()!=null||move.rgetnext().getvalue()==target)
		{
			move=move.rgetnext();
			if(move.lgetnext()!=null)
			{
				move=move.lgetnext();
				if(move.rgetnext()==null)
				{
					prev=prev.rgetnext();
					prev.svalue(move.getvalue());
					prev.lsetnext(null);
				}
				else
				{
					while(move.rgetnext().rgetnext()!=null)
						move=move.rgetnext();
					int temp=move.rgetnext().getvalue();
					prev.svalue(temp);
					System.out.println("Temp."+temp);
					move.rsetnext(null);
				}
			}
			else
				prev.rsetnext(move.rgetnext());
		}
	}
	public void replace(int targ,node look)
	{
		if(look!=null)
		{
			replace(targ,look.lgetnext());
			replace(targ,look.rgetnext());
			if(look.getvalue()==targ)
			{
				if(look.lgetnext()==null&&look.rgetnext()==null)
				{
					node pointer=root;
					delnochild(pointer,targ);
				}
				else
				{
				Delete(targ);
				}
			}
		}
	}
	public void delnochild(node pointer, int targ)
	{
		if(pointer.getvalue()==targ)
			if(pointer.lgetnext()==null&&pointer.rgetnext()==null)
				founded=true;
		if(pointer.lgetnext()!=null)
		{
			delnochild(pointer.lgetnext(),targ);
			if(founded==true)
			{
				pointer.lsetnext(null);
				founded=false;
			}
		}
		if(pointer.rgetnext()!=null)
		{
			delnochild(pointer.rgetnext(),targ);
			if(founded==true)
			{
				pointer.rsetnext(null);
				founded=false;
			}
		}
	}
	public void find()
	{
		node find=root;
		int see; 
		Scanner cin=new Scanner(System.in);
		System.out.println("Input number to look for.");
		see=cin.nextInt();
		Find(find,see,level);
		if(iftrue==true)
			System.out.println(see+" is in the tree.");
		else
			System.out.println(see+" isn't in the tree");
	}
	public void Find(node fin,int targ,int level)
	{
		if(fin!=null)
		{
				Find(fin.lgetnext(),targ,++level);
				--level;
				if(fin.getvalue()==targ)
				{
					System.out.println(targ+" is on level "+level);
					iftrue=true;
				}
				Find(fin.rgetnext(),targ,++level);
		}
	}
	public void balance()
	{
		
		node pass=root;
		if(iolist.isEmpty()==false)
		{
		iolist.clear();
		}
		System.out.println(iolist.toString());
		createarray(pass);
		root=null;
		balancetree(iolist,0,iolist.size()-1);
	}
	public void balancetree(ArrayList<Integer> blist,int min,int max)
	{
		if (min > max) {
			return;
		} else {
			int midpoint = ((max-min)/2) + min;
			add(blist.get(midpoint));
			balancetree(blist, min, midpoint - 1);
			balancetree(blist, midpoint + 1, max);
		}
	}
	public void createarray(node passed)
	{
		if(passed!=null)
		{
			createarray(passed.lgetnext());
			iolist.add(passed.getvalue());
			createarray(passed.rgetnext());
		}
	}
	public void Display()
	{
		System.out.println("In-order traversal");
		node pass=root;
		display(pass);
	}
	public void display(node recursive)
	{
		if(recursive!=null)
		{
		display(recursive.lgetnext());
		System.out.print(recursive.getvalue()+" ");
		display(recursive.rgetnext());
		}
	}
	public void stats()
	{
		node deeps=root;
		node make=root;
		iolist.clear();
		createarray(make);
		System.out.println("# of items in tree="+iolist.size());
		System.out.println("Depth of tree is:"+(depths(deeps)-1));
		System.out.println("Root value is:"+deeps.getvalue());
	}
	public int depths(node deep)
	{
		if(deep==null)
			return 0;
		else
			  return 1+Math.max(depths(deep.lgetnext()),depths(deep.rgetnext()));
	}
	private class node
	{
		private int num;
		private node lc;
		private node rc;
		public node(int number)
		{
			lc=null;
			rc=null;
			num=number;
		}
		public int getvalue()
		{
			return num;
		}
		public void svalue(int val)
		{
			num=val;
		}
		public void rsetnext(node anode)
		{
			rc=anode;
		}
		public void lsetnext(node anode)
		{
			lc=anode;
		}
		public node rgetnext()
		{
			return rc;
		}
		public node lgetnext()
		{
			return lc;
		}
	}
}
