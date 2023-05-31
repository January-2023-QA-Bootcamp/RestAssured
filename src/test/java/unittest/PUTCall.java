package unittest;

import java.util.HashMap;
import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class PUTCall {

	@Test
	public void updateRecord() {
		Map<String, Object> map = new HashMap<>();
		map.put("id", 20);
		map.put("countryName", "Australia");
		map.put("iccRank", 2);
		
		RestAssured.given()
		.log().all()
		.body(map)
		.contentType(ContentType.JSON)
		.put("http://localhost:3000/countries/"+map.get("id"))
		.then()
		.log().all()
		.statusCode(200);
	}
}
