import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;


public class StudentHash {

	public StudentHash(){
		Map<Integer, Student> students = new TreeMap<Integer, Student>();
		Map<Student, String> grades = new TreeMap<Student, String>();
		Set<Student> ehash = new HashSet<Student>();
		Scanner input = new Scanner(System.in);
		Scanner sin=new Scanner(System.in);
		int option = 0;
		while (option != 6) {
			Menu();
			option = input.nextInt();
			if(option<0 || option>7){
				System.out.println("Enter again.");
				option=input.nextInt();
			}
			if(option==1){
				System.out.println("Enter First and Last name");
				String name=sin.nextLine();
				System.out.println(name);
				String[] temp=name.split("\\s+");
				while(temp.length!=2){
					System.out.println("Enter again");
					name=sin.nextLine();
					temp=name.split("\\s+");
					for(int a=0;a<temp.length;a++){
						System.out.println(temp[a]);
					}
				}
				System.out.println("Enter an id number");
				int id=input.nextInt();
				while(students.containsKey(id)){
					System.out.println("Invalid ID input");
					id=input.nextInt();
				}
				System.out.print("Enter Grade:");
				String grade=input.next();
				System.out.println("\n"+temp[0].toString()+" "+temp[1].toString()+" ID:"+id+" Grade:"+grade);
				Student tempE=new Student(temp[0].toString(),temp[1].toString(), id);
				students.put(tempE.getID(), tempE);
				grades.put(tempE, grade);
			}
			if(option==2){
				Set<Student> List = grades.keySet();
				for (Student e : List) {
					System.out.println("Grade:" + e + ": " + grades.get(e));
				}
				System.out.println("Enter an id number to remove.");
				int id=input.nextInt();
				if(students.containsKey(id)){
				grades.remove(students.get(id));
				students.remove(id);
				}
			}
			if(option==3){
				int gradess=0;
				while(gradess!=3){
					grades();
					gradess=input.nextInt();
					if(gradess<0 || gradess >3){
						System.out.println("Enter again");
						gradess=input.nextInt();
					}
					if(gradess==1){
						Set<Student> List = grades.keySet();
						for (Student e : List) {
							System.out.println("Grade:" + e + ": " + grades.get(e));
						}
						System.out.println("Enter an id number to modify.");
						int id=input.nextInt();
						if(!students.containsKey(id)){
							System.out.println("Enter again");
							id=input.nextInt();
						}
						System.out.println("Enter new grade.");
						String grade=input.next();
						grades.put(students.get(id), grade);
					}
					if(gradess==2){
						Set<Student> List = grades.keySet();
						for (Student e : List) {
							System.out.println("Grade:" + e + ": " + grades.get(e));
						}
					}
					if(gradess==3){
						break;
					}
				}
			}
			if(option==4){
				Set<Student> StudentList = grades.keySet();
				for (Student e : StudentList) {
					ehash.add(e);
				}
				for (Student e : ehash) {
					System.out.println("Hash code of student " + e + ": " + e.hashCode());
				}
			}
			if(option==5){
				Set<Student> List = grades.keySet();
				if(List.size()==0){
					System.out.println("Empty");
				}
				else{
				for (Student e : List) {
					System.out.println("Grade:" + e + ": " + grades.get(e));
				}
				}
			}
			if(option==6){
				break;
			}
			if(option==7){
				Student tempd=new Student("John","Rogers", 99);
				students.put(tempd.getID(), tempd);
				grades.put(tempd, "A");
				Student tempb=new Student("Brian","Bob", 123);
				students.put(tempb.getID(), tempb);
				grades.put(tempb, "C");
				Student tempE=new Student("Ryan","Ea", 122);
				students.put(tempE.getID(), tempE);
				grades.put(tempE, "B");
				Student tempc=new Student("Stan","Peters", 124);
				students.put(tempc.getID(), tempc);
				grades.put(tempc, "D");
				Student tempa=new Student("Kyle","Here", 125);
				students.put(tempa.getID(), tempa);
				grades.put(tempa, "F");
			}
		}
	}
	public void Menu() {
		System.out.println("1. Add"
				+ "\n2. Remove "
				+ "\n3. Grades"
				+ "\n4. Hash Code display"
				+ "\n5. Display"
				+ "\n6. Quit ");
	}
	public void grades(){
		System.out.println("1. Change"
				+ "\n2. Display"
				+ "\n3. Exit this menu");
	}
}
