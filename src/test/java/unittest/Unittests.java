package unittest;

import java.io.File;

import org.testng.annotations.Test;

import common.Endpoint;
import utils.Configuration;

public class Unittests {

	@Test
	public void fileTest() {
		File file = new File("src/main/resources/config.properties");
		System.out.println(file.exists());
	}
	
	@Test
	public void endpointEnumTest() {
		System.out.println(Endpoint.COUNTRIES.getEndpoint());
	}
	
	@Test
	public void testConfigProperties() {
		Configuration configuration = new Configuration();
		System.out.println(configuration.getUrl());
	}
	
}
