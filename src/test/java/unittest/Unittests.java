package unittest;

import java.io.File;

import org.testng.annotations.Test;

public class Unittests {

	@Test
	public void fileTest() {
		File file = new File("src/test/resources/country.json");
		System.out.println(file.exists());
	}
}
