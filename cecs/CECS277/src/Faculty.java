
public class Faculty extends Employee implements Cloneable,EmployeeInfo{
	public String level;
	public String AS="Assistant Professor";
	public String AO="Associate Professor";
	public String FU="Professor";
	private Education eduInfo=new Education();
	public void setLevel(String sLevel){
		if(sLevel.equalsIgnoreCase("AS")){
			level=AS;
		}
		else if(sLevel.equalsIgnoreCase("AO")){
			level=AO;
		}
		else if(sLevel.equalsIgnoreCase("FU")){
			level=FU;
		}
		else
			level="ERROR";
	}
	public String getLevel(){
		return level;
	}
	public void setEducation(String deg, String maj, int Res){
		eduInfo.setDegree(deg);
		eduInfo.setMajor(maj);
		eduInfo.setResearch(Res);
	}
	public Education getEducation(){
		return eduInfo;
	}
	public double monthlyEarnings() {
		if(level.equalsIgnoreCase(AS)){
		return FACULTY_MONTHLY_SALARY;
		}
		else if(level.equalsIgnoreCase(AO)){
			return FACULTY_MONTHLY_SALARY*1.2;
		}
		else if(level.equalsIgnoreCase(FU)){
			return FACULTY_MONTHLY_SALARY*1.4;
		}
		return 0;
	}
	public Object clone() throws CloneNotSupportedException {
		Faculty cloned=(Faculty) super.clone();
		Education clonedEd = (Education) eduInfo.clone();
		cloned.setEducation(clonedEd);
		return cloned;
	}
	public void setEducation(Education edu){
		this.eduInfo=edu;
	}
	public String toString(){
		return super.toString()+getLevel()+"\nDegree:"+eduInfo.getDegree()+"\nResearch:"+eduInfo.getResearch()
				+"\nMonthly Earnings:$"+monthlyEarnings();
	}
	public int compareTo(Employee e) {
		return this.getLName().compareTo(e.getLName());
	}
}
