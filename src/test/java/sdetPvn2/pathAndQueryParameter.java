package sdetPvn2;
import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;
public class pathAndQueryParameter {
	
	@Test
	void testpathnQueryparam() {
		given()
		.pathParam("mypath", "users")    //path parameter
		.queryParam("page", 2)     //query parameter 1
		.queryParam("id", 8)     // query parameter 2
		.when().get("https://reqres.in/api/{mypath}")  //we only specify path parameter key and no need to specify query params since it directly take
		
		.then()
		.statusCode(200).log().all();
	}

}
