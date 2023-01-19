package Test2Latest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetTest_1 {
	
	public void getWetherStatus() {
		baseURI = "https://reqres.in";
		RequestSpecification rs = RestAssured.given();
		Response response = rs.request(Method.GET, "/api/users/2");
		int statusCode = response.getStatusCode();
		JsonPath path = response.jsonPath();
		Assert.assertEquals(statusCode, 200);
		String statusLine = response.getStatusLine();
		Assert.assertEquals(statusLine, "HTTP/1.1 200 OK");
		String ex = path.get("");
		
		String content = response.header("Content-type");
		Assert.assertEquals(content, "application/json; charset=utf-8");
	}
	@Test
	void getnames() {
		baseURI = "https://reqres.in";
		RequestSpecification rs = RestAssured.given();
		Response response = rs.request(Method.GET, "api/users?page=2");
		JsonPath path = response.jsonPath();
		System.out.println(path.get("data.first_name"));
		for(Object s: path.getList("data.first_name")) {
			if(s.equals("Rachel")) {
				System.out.println("name matched : "+s);
			}
		}
		
	}
}
