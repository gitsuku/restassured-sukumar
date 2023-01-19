package Test2Latest;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import groovy.grape.GrapeIvy;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class postRequesrt2 {
	
	@SuppressWarnings("unchecked")
	@Test(enabled = false)
	void getheaders() {
		baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification rs = RestAssured.given();
		JSONObject reqParms = new JSONObject();
		reqParms.put("Name", "sukumar");
		reqParms.put("age", "28");
		reqParms.put("salary", "1lac");
		//adding the header stating the request body is json
		rs.header("Content-Type", "application/json");
		//rs.contentType("application/json");
		rs.body(reqParms.toJSONString());
		Response response = rs.request(Method.POST, "/create");
		 
		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains("sukumar"), true);
		Assert.assertEquals(responseBody.contains("28"), true);
		
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
		
	}
	@Test
	//BDD based post request
	void postReq() {
		baseURI = "https://jsonplaceholder.typicode.com";
		String requestBody = "{\n" +
	            "  \"title\": \"foo\",\n" +
	            "  \"body\": \"bar\",\n" +
	            "  \"userId\": \"1\" \n}";
		Response response = RestAssured.given().header("content-type", "application/json")
				.and()
				.body(requestBody)
				.when()
				.post("/posts").
				then().extract().response();
		JsonPath path = response.jsonPath();
		Assert.assertEquals(path.get("title"), "foo");	
		Assert.assertEquals(response.getStatusCode(), 201);
		
	}
	@Test
	void puttReq() {
		baseURI = "https://jsonplaceholder.typicode.com";
		String requestBody = "{\n" +
	            "  \"title\": \"foo\",\n" +
	            "  \"body\": \"baz\",\n" +
	            "  \"userId\": \"1\",\n" +
	            "  \"id\": \"12\" \n}";
		RequestSpecification rs = RestAssured.given();
		rs.header("Content-Type", "application/json");
		rs.body(requestBody).toString();
		Response response = rs.request(Method.PUT, "/posts/1");
		JsonPath js = response.jsonPath();
		Assert.assertEquals(js.get("title"), "foo");
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}
	@Test
	void patch() {
		baseURI = "https://jsonplaceholder.typicode.com";
		String requestBody = "{\n" +
	            "  \"title\": \"sukumar\" \n}";
	           
		RequestSpecification rs = RestAssured.given();
		rs.header("Content-Type", "application/json");
		rs.body(requestBody).toString();
		Response response = rs.request(Method.PATCH, "/posts/1");
		JsonPath js = response.jsonPath();
		Assert.assertEquals(js.get("title"), "sukumar");
		Assert.assertEquals(response.getStatusCode(), 200);
	}

}
