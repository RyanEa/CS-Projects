import java.util.*;
public class LAB3 {
	public static void main(String[] args){
		Random a=new Random();
		Integer[] alist=new Integer[15];
		Integer[] alist2=new Integer[15];
		for(int x=0;x<15;x++){
			alist[x]=a.nextInt(30);
			alist2[x]=a.nextInt(30);
		}
		InsertionSort.InsertionSort(alist);
		BinarySearcher temp=new BinarySearcher(alist);
		for(int x=0;x<15;x++){
			if(temp.BinarySearch(alist2[x])<0){
				System.out.println("Yes "+alist[x]+" is in common in the original list");
			}
		}
	}
}

public class InsertionSort <T extends Comparable<T>>{
	public static <T extends Comparable<T>> void InsertionSort(T[] a) {
		for(int n=1;n<a.length;n++){
			T next=a[n];
			int l=n;
			while(l>0 && a[l-1].compareTo(next)>0)
			{
				a[l]=a[l-1];
				l--;
			}
			a[l]=next;
		}
	}
	public static <T extends Comparable<T>> void ISort(T[] a){
		for(int n=1;n<a.length;n++){
			T next=a[n];
			int l=n;
			while(l>0 && a[l-1].compareTo(next)>0)
			{
				a[l]=a[l-1];
				l--;
			}
			a[l]=next;
		}
	}
}