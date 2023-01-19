package tests;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;
public class getAndPost {
	@Test
public void get() {
	baseURI ="https://reqres.in/api";
	given().get("/users?page=2").then().statusCode(200).body("data[0].first_name", equalTo("Michael")).
	body("data.first_name", hasItems("Michael", "Lindsay"));
		
}
	@Test
	public void post() {
		Map<String ,Object> map = new HashMap<String, Object>();
		map.put("name", "sukumar");
		map.put("job", "SA");
		JSONObject req = new JSONObject(map);
	}
	//using JsonObject creating json format
	@Test(priority = 0)
	public void post2() {

		JSONObject req = new JSONObject();
		req.put("name", "sukumar");
		req.put("job", "SA");
		baseURI ="https://reqres.in/api";
		given().
		header("Content-Type", "application/json").
		contentType(ContentType.JSON).accept(ContentType.JSON).
		body(req.toJSONString()).when().post("/users").then().statusCode(201).log().all();
		
	}
}
