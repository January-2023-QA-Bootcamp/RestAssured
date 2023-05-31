package unittest;

import org.testng.annotations.Test;

import io.restassured.RestAssured;

public class DeleteCall {

	@Test
	public void deleteCall() {
		RestAssured.given()
		.log().all()
		.delete("http://localhost:3000/countries/87")
		.then()
		.log().all();
	}
}
