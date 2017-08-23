import java.util.Scanner;
import java.util.Random;
public class Lab3Test {
	public static void main(String[] args) {
		//------------------------------------------------------------------------
		Faculty d=new Faculty();
		d.setLName("Johnson");d.setFName("Anne");d.setGender("F");d.setIdNumber("243");
		d.setCalender(62, 4, 27);d.setLevel("FU");d.setEducation("Ph.D", "Engineering", 3);
		Faculty e=new Faculty();
		e.setLName("Bouris");e.setFName("William");e.setGender("F");e.setIdNumber("791");
		e.setCalender(75, 3, 14);e.setLevel("AO");e.setEducation("Ph.D", "English", 1);
		Faculty f=new Faculty();
		f.setLName("Andrade");f.setFName("Christopher");f.setGender("F");f.setIdNumber("623");
		f.setCalender(80, 5, 22);f.setLevel("AS");f.setEducation("MS","Physical Education",0);
		Faculty temp=new Faculty();
		temp.setLName("");temp.setFName("Null");temp.setGender("");temp.setIdNumber("");
		temp.setCalender(00, 0, 0);temp.setLevel("AS");temp.setEducation("MS","TEMP",0);
		//-------------------------------------------------------------------------
		Faculty[] array = {d,e,f};
		System.out.println("-------UNSORTED Faculty--------------");
		for(int n=0;n<array.length;n++){
			System.out.println(array[n]);
		}
		InsertionSort.InsertionSort(array);
		BinarySearcher bsearch= new BinarySearcher(array);
		Scanner input = new Scanner(System.in);
		String a;
		System.out.println("-------SORTED Faculty--------------");
		for(int n=0;n<array.length;n++){
			System.out.println(array[n].getLName());
		}
		System.out.println("-----------------Binary Search Algorithm-----------------");
		System.out.println("Input a last name to search.(Case sensitive)");
		a=input.nextLine();
		temp.setLName(a);
		System.out.println("Index"+bsearch.BinarySearch(temp)+" is the location of the search.");
		if(bsearch.BinarySearch(temp)>-1){
		System.out.println(array[bsearch.BinarySearch(temp)]);
		}
		
		System.out.println("-----------------Insertion Sort w/ Numbers------------------");
		System.out.print("Enter how many numbers to enter:");
		int t=input.nextInt();
		while(t<0){
			System.out.println("Enter again");
			t=input.nextInt();
		}
		Integer[] stuff=new Integer[t];
		for(int n=0;n<stuff.length;n++){
			System.out.println("Enter number #"+n+1+" ");
			stuff[n]=input.nextInt();
		}
		System.out.println("--------Unsorted List---------");
		for(int n=0;n<stuff.length;n++){
			System.out.print(stuff[n]+ " ");
		}
		System.out.println("\n--------Sorted List---------");
		InsertionSort.InsertionSort(stuff);
		for(int n=0;n<stuff.length;n++){
			System.out.print(stuff[n]+ " ");
		}
		BinarySearcher isearch= new BinarySearcher(stuff);
		System.out.println("Enter an int to search");
		t=input.nextInt();
		System.out.println("Index:"+isearch.BinarySearch(t));
	}
}
