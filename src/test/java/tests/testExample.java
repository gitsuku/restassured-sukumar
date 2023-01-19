package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
public class testExample {
   @Test
	public void test1() {
		Response response = get("https://reqres.in/api/users?page=2");
		
		System.out.println(response.getStatusCode());
		System.out.println(response.getBody());
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 120);
		
	}
   @Test
   public void test2() {
	   baseURI = "https://reqres.in/api";
	   given().get("/users?page=2").then().statusCode(200).body("data[1].id", equalTo(8)).log().all();
   }
}
