import java.util.Arrays;
public class Lab2Main {
	public static void main(String[] args) throws CloneNotSupportedException{
	Employee[] list=new Employee[9];
	Staff a=new Staff();
	Staff b=new Staff();
	Staff c=new Staff();
	a.setLName("Paita");a.setFName("Allen");a.setGender("M");
	a.setCalender(59, 2, 23);a.setRate(50);a.setIdNumber("123");
	b.setLName("Zapata");b.setFName("Steven");b.setGender("F");
	b.setCalender(64, 7, 12);b.setRate(35);b.setIdNumber("456");
	c.setLName("Rios");c.setFName("Enrique");c.setGender("M");
	c.setCalender(70, 7, 12);c.setRate(40);c.setIdNumber("789");
	list[0]=a;
	list[1]=b;
	list[2]=c;
	Faculty d=new Faculty();
	d.setLName("Johnson");d.setFName("Anne");d.setGender("F");d.setIdNumber("243");
	d.setCalender(62, 4, 27);d.setLevel("FU");d.setEducation("Ph.D", "Engineering", 3);
	Faculty e=new Faculty();
	e.setLName("Bouris");e.setFName("William");e.setGender("F");e.setIdNumber("791");
	e.setCalender(75, 3, 14);e.setLevel("AO");e.setEducation("Ph.D", "English", 1);
	Faculty f=new Faculty();
	f.setLName("Andrade");f.setFName("Christopher");f.setGender("F");f.setIdNumber("623");
	f.setCalender(80, 5, 22);f.setLevel("AS");f.setEducation("MS","Physical Education",0);
	list[3]=d;
	list[4]=e;
	list[5]=f;
	PartTime g=new PartTime();
	PartTime h=new PartTime();
	PartTime i=new PartTime();
	g.setLName("Guzman");g.setFName("Augusto");g.setIdNumber("455");g.setGender("F");
	g.setCalender(77, 8, 10);g.setRate(35.00);g.setHours(30);
	h.setLName("Depirro");h.setFName("Martin");h.setIdNumber("678");h.setGender("F");
	h.setCalender(87, 9, 15);h.setRate(30.00);h.setHours(15);
	i.setLName("Aldaco");i.setFName("Marque");i.setIdNumber("945");i.setGender("M");
	i.setCalender(88, 11, 22);i.setRate(20.00);i.setHours(35);
	list[6]=g;
	list[7]=h;
	list[8]=i;
	for(Employee x:list){
		System.out.println(x+"\n");
	}
	System.out.println("------------LAST NAME ASCENDING----------------");
	Arrays.sort(list);
	for(Employee x:list){
		System.out.println(x+"\n");
	}
	System.out.println("---------------ID # DESCENDING-------------");
	Arrays.sort(list,Employee.IdDesc);
	for(Employee x:list){
		System.out.println(x+"\n");
	}
	System.out.println("--------------CLONING FACULTY-----------");
	Faculty tests=(Faculty)d.clone();
	System.out.println("1st faculty:---------------------\n"+d.toString());
	System.out.println("Cloned one:----------------------\n"+tests.toString());
	System.out.println("\n"+(g.monthlyEarnings()+h.monthlyEarnings()+i.monthlyEarnings()));
	double total=0.00;
	for(Employee x:list){
		total+=x.monthlyEarnings();
	}
	System.out.println(total);
	}
}
