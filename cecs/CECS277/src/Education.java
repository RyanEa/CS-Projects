
public class Education implements Cloneable{
	private String degree,major;
	private int research;
	public void setDegree(String aDegree){
		degree=aDegree;
	}
	public String getDegree(){
		return degree;
	}
	public void setMajor(String aMajor){
		major=aMajor;
	}
	public String getMajor(){
		return major;
	}
	public void setResearch(int tResearch){
		research=tResearch;
	}
	public int getResearch(){
		return research;
	}
	public Object clone() throws CloneNotSupportedException{
		return super.clone();
	}
}
