
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