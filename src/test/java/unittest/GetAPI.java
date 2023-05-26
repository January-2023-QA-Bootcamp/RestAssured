package unittest;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import static org.hamcrest.Matchers.*;

public class GetAPI {

	@Test
	public void getAPI() {
		RestAssured
		.given().baseUri("http://localhost:3000/countries")
		.get()
		.prettyPrint();
	}
	
	@Test
	public void logAll() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/countries")
		.then()
		.log().all();
	}
	
	@Test
	public void assertStatusCodeAndHeader() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/countries")
		.then()
		.log().all()
		.statusCode(200) //Status code validation
		.header("Connection", equalTo("keep-alive")); //Response header validation
	}
	
	@Test
	public void assertBody() {
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/countries")
		.then()
		.log().all()
		.statusCode(200) //Status code validation
		.header("Connection", equalTo("keep-alive"))
		.body("id[0]", notNullValue())
		.body("countryName[1]", containsStringIgnoringCase("bangladesh"));
	}
}
