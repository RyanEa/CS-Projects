	public class Student implements Comparable<Student>{
		public String firstName;
		public String lastName;
		public int id;
		
		public Student() {
			firstName = "";
			lastName = "";
			id = 0;
		}
		
		public Student(String firstName, String lastName, int idNumber) {
			this.firstName = firstName;
			this.lastName = lastName;
			this.id = idNumber;
		}
		
		public String toString() {
			return firstName + " " + lastName + " (ID Number: " + id + ")";
		}
		public boolean equals(Student e) {
			if (firstName.equals(e.firstName) && lastName.equals(e.lastName) && id == e.id) {
				return true;
			}
			return false;
		}
		public int hashCode() {
			final int HASH_MULTIPLIER = 29;
			int h = HASH_MULTIPLIER * firstName.hashCode() + lastName.hashCode();
			h = HASH_MULTIPLIER * h + ((Integer) id).hashCode();
			return h;
		}
		public int getID(){
			return id;
		}
		public int compareTo(Student e) {
			if(lastName.compareToIgnoreCase(e.lastName)==0){
				if(firstName.compareToIgnoreCase(e.firstName)==0){
					return id-e.id;
				}
				return firstName.compareToIgnoreCase(e.firstName);
		}
			return lastName.compareToIgnoreCase(e.lastName);
	}
}