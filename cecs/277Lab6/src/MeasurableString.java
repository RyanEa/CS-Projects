import java.util.ArrayList;

public class MeasurableString<T> extends Measurable implements Comparable<MeasurableString> {
	public String string;
	public MeasurableString() {
		string = "";
	}
	public MeasurableString(String data) {
		this.string = data;
	}
	
	public int getMeasure() {
		return string.length();
	}
	
	public int compareTo(MeasurableString s) {
		return this.getMeasure()-s.getMeasure();
	}
	
	public String toString() {
		return string;
	}
	public String Largest(ArrayList<T> arrays){
		return super.largest(arrays).toString();
	}
}