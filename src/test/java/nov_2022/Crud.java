package nov_2022;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;


public class Crud {

@Test(enabled = false)	
	void get() {
		baseURI = "https://reqres.in/api/users";
		//RequestSpecification rs = RestAssured.given();
		given().get("?page=2").
		then().statusCode(200).body("page", equalTo(2));
		
	}
@Test(enabled = false)	
void post() {
	baseURI = "https://reqres.in/api/users";
	
	String data = "{\r\n"
			+ "    \"name\": \"morpheus\",\r\n"
			+ "    \"job\": \"leader\"\r\n"
			+ "}";
	given().body(data).
	when().post(). 
	then().log().all().
	assertThat().statusCode(201).body("id", is(notNullValue()));
}
@Test
	void patch() {
		baseURI = "https://reqres.in/api/users/2";
		
		String data = "{\r\n"
				+ "    \"name\": \"morpheus\",\r\n"
				+ "    \"job\": \"testing job\"\r\n"
				+ "}";
		
		given().body(data).
		when().patch(). 
		then().log().all().
		assertThat().statusCode(200);
	}
	
	
	
}
