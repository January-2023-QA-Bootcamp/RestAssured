package serialization_des;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.testng.annotations.Test;

public class ImpSerialization {

	@Test
	public static void main() throws IOException, ClassNotFoundException {
		//serialize();
		deserialize();
	}
	
	public static void serialize() throws IOException {
		SerializationClass serialization = new SerializationClass("John", 3);
		
		FileOutputStream fileOutputStream = new FileOutputStream("src/test/resources/serial.txt");
		ObjectOutputStream oStream = new ObjectOutputStream(fileOutputStream);
		
		oStream.writeObject(serialization);
		oStream.close();
		fileOutputStream.close();
		System.out.println("Serialized");
	}
	
	public static void deserialize() throws IOException, ClassNotFoundException {
		FileInputStream inputStream = new FileInputStream("src/test/resources/serial.txt");
		ObjectInputStream oStream = new ObjectInputStream(inputStream);
		
		SerializationClass deserialization = (SerializationClass)oStream.readObject();
		
		System.out.println(deserialization.getName());
		System.out.println(deserialization.getRoll());
	}
}
