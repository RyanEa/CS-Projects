
public class RationalMain
{
	public static void main(String args[])
	{
		Rational F1=new Rational();
		Rational F2=new Rational();
		Rational F3=new Rational();
		System.out.println("F1");
		F1.inputRational();
		System.out.println("F2");
		F2.inputRational();
		//Adding two fractions, sets F3 numerator/denominator to one of the 2 numbers
		F3.setNumerator(F1.getNumerator());
		F3.setDenominator(F1.getDenominator());
		F3=F3.add(F2);
		System.out.println(F1.toString()+"+"+F2.toString()+"="+F3.toString());
		//Subtracting F2 from F1
		F3.sub(F1, F2);
		F3.setNumerator(F3.getNumerator());
		F3.setDenominator(F3.getDenominator());
		System.out.println(F1.toString()+"-"+F2.toString()+"="+F3.toString());
		//Multiplying F1 & F2, sets F3 numerator/denominator to one of the 2 numbers
		F3.setNumerator(F1.getNumerator());
		F3.setDenominator(F1.getDenominator());
		F3=F3.mul(F2);
		System.out.println(F1.toString()+" * "+F2.toString()+"="+F3.toString());
		//Division of F2 from F1
		F3.div(F1, F2);
		F3.setNumerator(F3.getNumerator());
		F3.setDenominator(F3.getDenominator());
		System.out.println(F1.toString()+" / "+F2.toString()+"="+F3.toString());
		//Shows the real value of the division.
		System.out.println(F1.toString()+" / "+F2.toString()+"="+Rational(F1,F2));
		//Setting F1 numerator to 2
		F1.setNumerator(2);
		//Setting F2 denominator to 5
		F2.setDenominator(5);
		System.out.print("Numerator:"+F1.getNumerator()+"\n"+"Denominator:"+F2.getDenominator()+"\n");
	}
	public static double Rational(Rational f1,Rational f2)
	{
		double result;
		result = (double)(f1.getNumerator()*f2.getDenominator())/(double)(f1.getDenominator()*f2.getNumerator());
		return result;
	}
}
