package practice;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.inject.matcher.Matchers;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class jsonresponse {
	RequestSpecification rs;
	Response response;
	@BeforeClass
	void main() {
		baseURI = "https://run.mocky.io";
		rs = RestAssured.given();
	}
	@Test
	void getdetails() {		
	 rs = RestAssured.given();
		 response = rs.request(Method.GET, "/e3f5da9c-6692-48c5-8dfe-9c3348cfd5c7");
		String body = response.getBody().asString();
		JsonPath jp = response.jsonPath();
		Assert.assertEquals(jp.get("Course"), "Automation Testing");
		Assert.assertEquals(jp.get("Price"), "$23");
	}
	@Test
	void headervalidate() {
		given().when().get("/v3/6c6ed634-5e78-4b80-94c7-cf17c04c7055").then()
		.log().all().assertThat().statusCode(200)
		.body("location", org.hamcrest.Matchers.equalTo("Makinac Island")).header("content-length", "57");
		
	}
	
	
	
	
	
	

}
