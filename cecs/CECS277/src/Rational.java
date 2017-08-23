import java.util.Scanner;
public class Rational
{
	private int numerator;
	private int denominator;
	public int getNumerator()
	{
		return numerator;
	}	
	public int getDenominator()
	{
		return denominator;
	}
	public void setNumerator(int value)
	{
		numerator=value;
	}
	public void setDenominator(int value)
	{
		denominator=value;
	}
	public void inputRational()
	{
		Scanner input=new Scanner(System.in);
		System.out.println("Input numerator");
		setNumerator(input.nextInt());
		System.out.println("Input denominator");
		setDenominator(input.nextInt());
	}
	public String toString()
	{
		return getNumerator()+"/"+getDenominator();
	}
	private int gcd(int m, int n)
	{
		int r;
		while(n!=0)
		{
			r=m%n;
			m=n;
			n=r;
		}
		return m;
	}
	/**
	 * Adds two rational numbers together
	 * @param f number being added
	 * @return returns a rational
	 */
	public Rational add(Rational f)
	{
		Rational temp=new Rational();//creates a temp object;
		temp.numerator=f.numerator*denominator+f.denominator*numerator;//numerator calculations
		temp.denominator=f.denominator*denominator;//denominator calculations
		int gcd1=gcd(temp.numerator,temp.denominator);
		temp.setNumerator(temp.numerator/gcd1);//reduces numerator
		temp.setDenominator(temp.denominator/gcd1);//reduces denominator
		return temp;
	}
	/**
	 * Subtracting second number from the first number
	 * @param f1 first number
	 * @param f2 second number
	 */
	public void sub(Rational f1, Rational f2)
	{
		setNumerator(f1.numerator*f2.denominator-f1.denominator*f2.numerator);
		setDenominator(f1.denominator*f2.denominator);
		int gcd1=gcd(numerator,denominator);
		setNumerator(numerator/gcd1);//reduces numerator
		setDenominator(denominator/gcd1);//reduces denominator
	}
	public void div(Rational f1,Rational f2)
	{
		numerator=f1.numerator*f2.denominator;
		denominator=f1.denominator*f2.numerator;			
		int gcd1=gcd(numerator, denominator);
		setNumerator(numerator/gcd1);//reduces numerator
		setDenominator(denominator/gcd1);//reduces denominator
	}
	public Rational mul(Rational f)
	{
		Rational temp=new Rational();
		temp.numerator=f.numerator*numerator;
		temp.denominator=f.denominator*denominator;
		int gcd1=gcd(temp.numerator,temp.denominator);
		temp.setNumerator(temp.numerator/gcd1);//reduces numerator
		temp.setDenominator(temp.denominator/gcd1);//reduces denominator
		return temp;
	}
}
