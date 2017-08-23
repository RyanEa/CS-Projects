import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class EmployeeHash {

	public EmployeeHash(){
		Map<Integer, Employee> employees = new TreeMap<Integer, Employee>();
		Map<Employee, String> performance = new TreeMap<Employee, String>();
		Set<Employee> ehash = new HashSet<Employee>();
		Scanner input = new Scanner(System.in);
		Scanner sin=new Scanner(System.in);
		int option = 0;
		while (option != 5) {
			Menu();
			option = input.nextInt();
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
				while(employees.containsKey(id)){
					System.out.println("Wrong");
					id=input.nextInt();
				}
				System.out.print("Enter performance #:");
				String perf=input.next();
				System.out.println("\n"+temp[0].toString()+" "+temp[1].toString()+" ID:"+id+" Performance#:"+perf);
				Employee tempE=new Employee(temp[0].toString(),temp[1].toString(), id);
				employees.put(tempE.getID(), tempE);
				performance.put(tempE, perf);
			}
			if(option==2){
				Set<Employee> List = performance.keySet();
				for (Employee e : List) {
					System.out.println("Performance:" + e + ": " + performance.get(e));
				}
				System.out.println("Enter an id number to remove.");
				int id=input.nextInt();
				performance.remove(employees.get(id));
				employees.remove(id);
			}
			if(option==3){
				int perfs=0;
				while(perfs!=3){
					performance();
					perfs=input.nextInt();
					if(perfs==1){
						Set<Employee> List = performance.keySet();
						for (Employee e : List) {
							System.out.println("Performance:" + e + ": " + performance.get(e));
						}
						System.out.println("Enter an id number to modify.");
						int id=input.nextInt();
						System.out.println("Enter new performance.");
						String perf=input.next();
						performance.put(employees.get(id), perf);
					}
					if(perfs==2){
						Set<Employee> List = performance.keySet();
						for (Employee e : List) {
							System.out.println("Performance:" + e + ": " + performance.get(e));
						}
					}
					if(perfs==3){
						break;
					}
				}
			}
			if(option==4){
				Set<Employee> employeeList = performance.keySet();
				for (Employee e : employeeList) {
					ehash.add(e);
				}
				for (Employee e : ehash) {
					System.out.println("Hash code of employee " + e + ": " + e.hashCode());
				}
			}
			if(option==5){
				break;
			}
			if(option==6){
				Employee tempd=new Employee("John","Rogers", 99);
				employees.put(tempd.getID(), tempd);
				performance.put(tempd, "Good");
				Employee tempb=new Employee("Ryan","Bob", 123);
				employees.put(tempb.getID(), tempb);
				performance.put(tempb, "Ok");
				Employee tempE=new Employee("Ryan","Ea", 122);
				employees.put(tempE.getID(), tempE);
				performance.put(tempE, "Alright");
				Employee tempc=new Employee("Ryan","Bob", 124);
				employees.put(tempc.getID(), tempc);
				performance.put(tempc, "Bad");
				Employee tempa=new Employee("Kyle","Here", 125);
				employees.put(tempa.getID(), tempa);
				performance.put(tempa, "ok");
			}
		}
	}
	public void Menu() {
		System.out.println("1. Add"
				+ "\n2. Remove "
				+ "\n3. Performance"
				+ "\n4. Hash Code display"
				+ "\n5. Quit ");
	}
	public void performance(){
		System.out.println("1. Change"
				+ "\n2. Display"
				+ "\n3. Exit this menu");
	}
}
