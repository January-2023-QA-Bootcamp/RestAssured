package unittest;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.path.json.JsonPath;

public class JsonPathValidation {

	@Test
	public void validateJson() {
		File file =  new File("src/test/resources/complex.json");
		JsonPath jsonPath = new JsonPath(file);
		//System.out.println(jsonPath.getString("result.id"));
		//System.out.println(jsonPath.getMap("result.questions"));
		System.out.println(jsonPath.getList("blocks.BL_8e9WydYo33qZNJ3.elements"));
	}
	
	@Test
	public void jsonPathString() {
		JsonPath path = new JsonPath("{\"id\": 30,\"countryName\": \"Bangladesh\",\"iccRank\": 7}");
		System.out.println(path.getString("countryName"));
	}
	
}
