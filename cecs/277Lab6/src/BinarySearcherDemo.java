
public class BinarySearcherDemo {
	public static void main(String[] args){
		Integer[] temp=new Integer[42];
		for(int i=0;i<42;i++){
			temp[i]=i;
		}
		BinarySearcher bsearch=new BinarySearcher(temp);
		System.out.println("12:"+bsearch.search(12));
		System.out.println("23:"+bsearch.search(23));
	}
}
