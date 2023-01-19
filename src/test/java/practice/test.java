package practice;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
public class test {
	@Test
	public void test1() {
		baseURI ="https://reqres.in/api";
		given().get("/users?page=2").then().statusCode(200).body("data.id[1]", equalTo(8));
		//Response response = RestAssured.get("/users?page=2");			
	}
	@Test
	public void testGet() {
		baseURI ="https://reqres.in/api";
		given().get("https://reqres.in/api/unknown").then().statusCode(200).body("data[4].year", equalTo(2004)).body("data.name", hasItems("aqua sky","tigerlily"));
	}
	@Test
	public void post(){
		baseURI ="https://reqres.in/api";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "sukumar");
		map.put("age", 25);
		JSONObject j = new JSONObject(map);
		given().header("Content-type", "application/json").contentType(ContentType.JSON).body(j.toString()).when().post("users").then().statusCode(201).log().all();								
	}
	@Test
	public void put(){
		baseURI ="https://reqres.in/api";
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "sukumar");
		map.put("age", 25);
		JSONObject j = new JSONObject(map);
		given().header("Content-type", "application/json").contentType(ContentType.JSON).body(j.toString()).when().put("users/2").then().statusCode(200).log().all();
	}
	@Test

	public void delete() {
		baseURI ="https://reqres.in/api";
		when().delete("users/2").then().statusCode(204);
		
		
		
	}
	

}
