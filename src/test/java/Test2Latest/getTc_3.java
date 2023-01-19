package Test2Latest;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class getTc_3 {
	@Test
	public void getspecificDetail() {
		baseURI = "https://reqres.in/api";
		
		given().get("/users?page=2").then().statusCode(200).body("data[0].first_name", equalTo("Michael")).
		body("data.first_name", hasItems("Michael", "Lindsay"));
		
	}
	
	@Test
	public void sampleMethod() {
		baseURI = "https://reqres.in";
		RequestSpecification rs = RestAssured.given();
		Response response = rs.request(Method.GET, "/api/users/2");
		int statusCode = response.getStatusCode();
		JsonPath path = response.jsonPath();
		Assert.assertEquals(statusCode, 200);
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		String ex = path.get("data[0].first_name");
		System.out.println(ex);
	}

}
