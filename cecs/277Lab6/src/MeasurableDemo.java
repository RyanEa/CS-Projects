import java.util.ArrayList;

/**
This program demonstrates the Measurable class.
*/
public class MeasurableDemo
{
public static void main(String[] args)
{
ArrayList<MeasurableString> words = new ArrayList<MeasurableString>();
//Measurable<MeasurableString> Measurable = new Measurable<MeasurableString>();
MeasurableString Measurable=new MeasurableString();
words.add(new MeasurableString("Mary"));
words.add(new MeasurableString("had"));
words.add(new MeasurableString("aaaaaaa"));
words.add(new MeasurableString("little"));
words.add(new MeasurableString("lamb"));
System.out.println("Largest word: " + Measurable.Largest(words));
System.out.println("Expected: little");
}
}