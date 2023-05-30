package unittest;

import org.testng.Assert;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

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
	
	@Test
	public void addAuthorization_n_404() {
		RestAssured.given()
		.log().all()
		.auth().basic("user", "pass")
		.baseUri("http://localhost:3000")
		.get("/country")
		.then()
		.log().all()
		.statusCode(404);
	}
	
	@Test
	public void assertBody_jsonPath() {
		Response response =
		RestAssured.given()
		.log().all()
		.get("http://localhost:3000/countries");
		
		System.out.println(response.asPrettyString());
		
		JsonPath path = new JsonPath(response.asString());
		Assert.assertEquals(path.getString("id[3]"), "20");
	}
}
