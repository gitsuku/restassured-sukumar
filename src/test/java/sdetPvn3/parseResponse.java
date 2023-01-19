package sdetPvn3;
import static io.restassured.RestAssured.*;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class parseResponse {
	@Test
	void responseVal() {
		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/subjects");
		//Assert.assertEquals(res.contentType(), "");
		Assert.assertEquals(res.statusCode(),200);
		String sub = res.jsonPath().getString("subjects[1].status");
		Assert.assertEquals(sub, "f");
		
		
	}
	@Test
	void responseValWithJsonobject() {
		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/subjects");
		//Assert.assertEquals(res.contentType(), "");
		Assert.assertEquals(res.statusCode(),200);
		JSONObject jb = new JSONObject(res.toString());
		
		boolean status = false;
		for(int i=0; i<jb.getJSONArray("subjects").length(); i++) {
			String title = jb.getJSONArray("subjects").getJSONObject(i).get("title").toString();
			System.out.println("title is "+title);
			
			if(title.equals("xyz")) {
				status = true;
				break;
			}
		}
		Assert.assertEquals(status, true);
		
	}
	void validatePrice() {
		Response res = given().contentType(ContentType.JSON).when().get("http://localhost:3000/subjects");
		
		JSONObject jb = new JSONObject(res.toString());
		double totalPrice=0;
		for(int i=0; i<jb.getJSONArray("subjects").length(); i++) {
			String price = jb.getJSONArray("subjects").getJSONObject(i).get("price").toString();
			totalPrice = +Double.parseDouble(price);
		}
		Assert.assertEquals(totalPrice, 40.40);
	}

}
