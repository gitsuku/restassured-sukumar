package tests;

import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class put_deleteAPI {
	@Test(enabled = false)
	public void put() {

		JSONObject req = new JSONObject();
		req.put("name", "sukumar");
		req.put("job", "SA");
		baseURI ="https://reqres.in/api";
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(req.toJSONString()).when().put("/users").then().statusCode(200).log().all();
		
	}
	@Test
	public void delete() {
		baseURI ="https://reqres.in/api";
		given().when().delete("/users").then().statusCode(204).log().all();
	}

}
