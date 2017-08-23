import java.util.Calendar;
import java.util.Comparator;
import java.util.GregorianCalendar;
public abstract class Employee implements Cloneable, Comparable<Employee>{
	private String lastName;
	private String firstName;
	private String IdNumber;
	private String gender;
	GregorianCalendar birthDate= new GregorianCalendar();
	public String getLName(){
		return lastName;
	}
	public void setLName(String setL){
		lastName=setL;
	}
	public String getFName(){
		return firstName;
	}
	public void setFName(String setF){
		firstName=setF;
	}
	public String getIdNumber(){
		return IdNumber;
	}
	public void setIdNumber(String set){
		IdNumber=set;
	}
	public void setCalender(int year, int month, int date){
		birthDate.set(year, month, date);
	}
	public String getCalender(){
		String format= birthDate.get(Calendar.MONTH)+"/"+birthDate.get(Calendar.DAY_OF_MONTH)+"/"+birthDate.get(Calendar.YEAR);
		return format;
	}
	public String getGender(){
		return gender;
	}
	public void setGender(String set){
		gender=set;
	}
	public String toString()
	{
		String a="Employee ID#:"+getIdNumber()+"\n"+"Employee Name:"+getFName()+" "+getLName()+"\n"
				+"Birth date:"+getCalender()+"\n";
		return a;
	}
	public int compareTo(Employee e) {
		return this.lastName.compareToIgnoreCase(e.lastName);
	}
	public static Comparator<Employee> IdDesc = new Comparator<Employee>() {
		public int compare(Employee e1, Employee e2) {	
			return Integer.parseInt(e2.IdNumber)-Integer.parseInt(e1.IdNumber);
		}
	};
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
	public abstract double monthlyEarnings();
}
