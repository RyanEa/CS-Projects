
public class PartTime extends Staff implements EmployeeInfo{
	public int weekHours;
	public double hourlyrate;
	public int getHours(){
		return weekHours;
	}
	public void setHours(int worked){
		weekHours=worked;
	}
	public double getRate(){
		return hourlyrate;
	}
	public void setRate(double setrate){
		hourlyrate=setrate;
	}
	public double monthlyEarnings(){
		return weekHours*hourlyrate*4;
	}
	public String toString(){
		String a="ID Employee Number:"+getIdNumber()+"\n"+"Employee Name:"+getFName()+" "+getLName()+"\n"
				+"Birth date:"+getCalender()+"\nHours worked per month:"+weekHours+"\nMonthly Salary:$"+monthlyEarnings();
		return a;
	}
}
