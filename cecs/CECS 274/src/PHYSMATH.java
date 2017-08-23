
public class PHYSMATH
{
	public static void main(String[] args)
	{
		double W=.1*9.8;
		double R=.12;
		double m=.1;
		double r=.00625;
		double M=0.20;
		double g=9.8;
		double tmavg=8.687;
		double h=.5;
		double im=0;
		double io=1.4838*Math.pow(10,-4);
		double iexp;
		double ithe=2*M*R*R;
		System.out.println(io);
		im=((W*r*r)/g)*(((g*tmavg*tmavg)/(2*h))-1);
		iexp=im-io;
		System.out.println("IM="+im);
		System.out.println("Iexp="+iexp);
		System.out.println("Ithe="+ithe);
		double d=((ithe-iexp)/(.5*(ithe+iexp)))*100;
		System.out.println("D="+d);
		
	}
}
