import java.util.ArrayList;

public class Measurable<T extends Comparable<T>> {
	T biggest;
	public Measurable(){}
	public T largest(ArrayList<T> arrays){
		T biggest = arrays.get(0);
		for(int i=0; i<arrays.size(); i++){
			if(biggest.compareTo(arrays.get(i))<0)
				biggest=arrays.get(i);
		}
		return biggest;
	}
	public String toString(){
		String temp=biggest.toString();
		return temp;
	}
}
