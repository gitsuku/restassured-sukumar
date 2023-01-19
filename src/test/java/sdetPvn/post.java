package sdetPvn;
import static io.restassured.RestAssured.baseURI;

import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class post {
	
	//@Test(priority = 1)
	void postwithHashMap() {
		
		HashMap map = new HashMap();
		map.put("name", "santosh");
		map.put("location", "paris");
		
		String courseArr[] = {"datascinse", "AI"};
		map.put("courses", courseArr);
		
		given().contentType("application/json").body(map).when().post("http://localhost:3000/students").then().statusCode(201).
		body("name",equalTo("santosh")).
		body("location",equalTo("paris")).
		body("courses[0]", equalTo("datascinse")).
		header("Content-Type", "application/json; charset=utf-8").log().all();
		
	}
	//@Test(priority = 2)
	void deleterecord() {
		given().when().delete("http://localhost:3000/students/4").then().statusCode(200);
	}
	//@Test(priority = 3)
void postwithJsonLib() {
		
		JSONObject map = new JSONObject();
		map.put("name", "santosh");
		map.put("location", "paris");
		
		String courseArr[] = {"datascinse", "AI"};
		map.put("courses", courseArr);
		
		given().contentType("application/json").body(map).when().post("http://localhost:3000/students").then().statusCode(201).
		body("name",equalTo("santosh")).
		body("location",equalTo("paris")).
		body("courses[0]", equalTo("datascinse")).
		header("Content-Type", "application/json; charset=utf-8").log().all();
		
	}
	//@Test(priority = 4)
	void delete_postwithJsonLib() {
		given().when().delete("http://localhost:3000/students/4").then().statusCode(200);
	}
	
	@Test(priority = 1)
void postwithJPojoClass() {
		
		pojo_post data = new pojo_post();
		data.setName("ranjesh");
		data.setLocation("london");
		String courseArr[] = {"block chain", "supply chain", "dotnet"};
		data.setCourses(courseArr);
		
		given().contentType("application/json").body(data).when().post("http://localhost:3000/students").then().statusCode(201).
		body("name",equalTo("ranjesh")).
		body("location",equalTo("london")).
		body("courses[0]", equalTo("block chain")).
		header("Content-Type", "application/json; charset=utf-8").log().all();
		
	}
	@Test(priority = 2)
	void delete_postwithJPojoClass() {
		given().when().delete("http://localhost:3000/students/5").then().statusCode(200);
	}
	
void postwithExternalJsonFile() {
		
		File f  = new File(".\\body.json");
		FileReader fr = new FileReader(f);
		JSONTokener jt = new JSONTokener(fr);
		JSONObject data = new JSONObject(jt);
		
		given().contentType("application/json").body(data.toJSONString()).when().post("http://localhost:3000/students").then().statusCode(201).
		body("name",equalTo("ranjesh")).
		body("location",equalTo("paris")).
		body("courses[0]", equalTo("datascinse")).
		header("Content-Type", "application/json; charset=utf-8").log().all();
		
	}
	

}
