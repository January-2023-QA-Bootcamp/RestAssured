package serialization_des;

import java.io.Serializable;

public class SerializationClass implements Serializable{

	String studentName;
	int roll;
	
	public SerializationClass(String studentName, int rollNo) {
		this.studentName = studentName;
		roll = rollNo;
	}
	
	public String getName() {
		return studentName;
	}
	
	public int getRoll() {
		return roll;
	}
}
