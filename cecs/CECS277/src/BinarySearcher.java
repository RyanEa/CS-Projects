
public class BinarySearcher <T extends Comparable<T>> {
	private T[]array;
	
	public BinarySearcher(T[]array){
		super();
		this.array=array;
	}
	public int BinarySearch(T obj){
		int max=array.length-1;
		int mid;
		int min=0;
		while(min<=max){
			mid=(max+min)/2;
			if(array[mid].compareTo(obj)==0){
				return mid;
			}
			else if(array[mid].compareTo(obj)<0)
				min=mid+1;
			else
				max=mid-1;
		}
		return -1;
	}
}