
public class Staff extends Employee implements EmployeeInfo {
	private double hourlyRate=0;
	public double monthlyEarnings(){
		double earnings=hourlyRate*STAFF_MONTHLY_HOURS_WORKED;
		return earnings;
	}
	public void setRate(double rate){
		hourlyRate=rate;
	}
	public double getRate(){
		return hourlyRate;
	}
	public String toString(){
		//super.toString();
		String a="ID Employee Number:"+getIdNumber()+"\n"+"Employee Name:"+getFName()+" "+getLName()+"\n"
				+"Birth date:"+getCalender()+"\nFull Time\n"+"Monthly Salary:"+monthlyEarnings();
		return a;
	}
}
