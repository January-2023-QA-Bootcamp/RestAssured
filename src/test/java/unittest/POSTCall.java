package unittest;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class POSTCall {

	@Test
	public void doPost_n_500_n_stringBody() {
		RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON)
		.body("{\"id\": 30,\"countryName\": \"Bangladesh\",\"iccRank\": 7}")
		.post("http://localhost:3000/countries")
		.then()
		.log().all()
		.statusCode(500);
	}
	
	@Test
	public void doPost_w_file() {
		File file = new File("src/test/resources/country.json");
		RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(file)
		.post("http://localhost:3000/countries")
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test
	public void doPost_w_inputStream() {
		InputStream inputStream = getClass().getClassLoader().getResourceAsStream("country.json");
		RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(inputStream)
		.post("http://localhost:3000/countries")
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test
	public void doPost_w_map() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 83);
		map.put("countryName", "Ireland");
		map.put("iccRank", 13);
		
		RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(map)
		.post("http://localhost:3000/countries")
		.then()
		.log().all()
		.statusCode(201);
	}
	
	@Test
	public void doPost_w_byte_array() throws IOException {
		final byte [] arr = getClass().getClassLoader().getResourceAsStream("country.json").readAllBytes();
		RestAssured.given()
		.log().all()
		.contentType(ContentType.JSON)
		.body(arr)
		.post("http://localhost:3000/countries")
		.then()
		.log().all()
		.statusCode(201);
		//.body("id", Matchers.equalTo(1));
	}
}
