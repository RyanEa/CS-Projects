import java.util.*;
public class HeapSort 
{
	public static int asize=31;
	public static void main(String[] args)
	{
		Scanner in=new Scanner(System.in);
		int i=1;
		int temp=0;
		ArrayList<Integer>alist=new ArrayList<Integer>();
		alist.add(0);
		Random r= new Random();
		while(i<32)
		{
			temp=r.nextInt(90)+10;
			if(alist.contains(temp))
				;
			else
			{
				alist.add(i, temp);
				i++;	
			}
		}
		display(alist);
		fheap(alist);
		System.out.println("Enter anything to start the sort.");
		String word=in.nextLine();
		for(int b=asize;b>=1;b--)
		{
			swap(alist,1,b);
			asize--;
			hsort(alist,1);
		}
		System.out.println("Tree is sorted!");
		display(alist);
		System.out.println(alist.toString());
	}
	public static void fheap(ArrayList<Integer> al)
	{
		int i=asize/2;
		for(;i>0;i--)
		{
			hsort(al,i);
		}
	}
	public static void hsort(ArrayList<Integer> al,int  p)
	{
		int l=2*p;
		int r=2*p+1;
		int largest=p;
		if(l<=asize&& al.get(l)>al.get(p))
			largest=l;
		if(r<=asize&& al.get(r)>al.get(largest))
			largest=r;
		if(largest !=p)
		{
			swap(al,largest,p);
			display(al);
			System.out.println(al.toString());
			hsort(al,largest);
		}
	}
	public static void swap(ArrayList<Integer> al,int first,int second)
	{
		int temp=al.get(first);
		al.set(first, al.get(second));
		al.set(second, temp);
	}
	public static void display(ArrayList alist)
	{
		System.out.println("                                                 "+alist.get(1)+"                                    ");
		System.out.println("                              "+alist.get(2)+"------------------|---------------------"+alist.get(3)+"                 ");
		System.out.println("                 "+alist.get(4)+"-----------|-------"+alist.get(5)+"                    "+alist.get(6)+"----------|-------------"+alist.get(7));
		System.out.println("         "+alist.get(8)+"------|-----"+alist.get(9)+"        "+alist.get(10)+"----|----"+alist.get(11)+"         "+alist.get(12)+"----|----"+alist.get(13)+"            "+alist.get(14)+"-----|----"+alist.get(15));
		System.out.print("       "+alist.get(16)+"-|-"+alist.get(17)+"      "+alist.get(18)+"-|-"+alist.get(19));
		System.out.print("    "+alist.get(20)+"-|-"+alist.get(21)+"    "+alist.get(22)+"-|-"+alist.get(23));
		System.out.print("    "+alist.get(24)+"-|-"+alist.get(25)+"    "+alist.get(26)+"-|-"+alist.get(27));
		System.out.print("       "+alist.get(28)+"-|-"+alist.get(29)+"     "+alist.get(30)+"-|-"+alist.get(31));
		System.out.println("");
	}
}
