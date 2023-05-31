package apis.tests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import endpoint.Countries;
import utils.Configuration;

public class TestCountries {

	Countries countries;
	
	@BeforeTest
	public void init() {
		Configuration.loadProperties(TestCountries.class);
		countries = new Countries();
	}
	
	@Test
	public void getCountriesTest() {
		countries.logRequest();
		countries.getCountries();
		countries.logResponse();
		countries.responseCodeValidation(200);
		countries.bodyEqualValidation("countryName[2]", "Uganda");
	}
}
