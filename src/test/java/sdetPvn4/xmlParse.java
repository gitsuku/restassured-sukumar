package sdetPvn4;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.List;

import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class xmlParse {
	//http://restapi.adequateshop.com/api/Traveler?page=1
	@Test
	void xmlparsetest1() {
		given()
		.when().get("http://restapi.adequateshop.com/api/Traveler?page=1").then()
		.statusCode(200)
		.header("Content-Type", "application/xml; charset=utf-8")
		.body("TravelerinformationResponse.page", equalTo("1"))
		.body("TravelerinformationResponse.travelers.Travelerinformation[1].name", equalTo("AS"));
	}
	//approach2 returning the response in variable
	@Test
	void xmlparsetest2() {
	Response res = 	given()
		.when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
	Assert.assertEquals(res.statusCode(), 200);
	Assert.assertEquals(res.header("Content-Type"), "application/xml; charset=utf-8");
	String pagenum = res.xmlPath().get("TravelerinformationResponse.page").toString();
	Assert.assertEquals(pagenum, "1");
	
	String travelName = res.xmlPath().get("TravelerinformationResponse.travelers.Travelerinformation[1].name").toString();
	Assert.assertEquals(travelName, "AS");
	}
	@Test
	void testxmlResponseBody() {
		Response res = 	given()
				.when().get("http://restapi.adequateshop.com/api/Traveler?page=1");
		XmlPath xmlObj = new  XmlPath(res.asString());
		
		List<String> allTravelers = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation");
		
		int size = allTravelers.size();
		//verify the total num of traverls
		Assert.assertEquals(size, 10);
		
		List<String> names = xmlObj.getList("TravelerinformationResponse.travelers.Travelerinformation.name");
		boolean status = false;
		for(String travelerName : names) {
			
			if(travelerName.equals("AS")) {
				status =true;
				break;
			}
		}
		Assert.assertEquals(status, true);
	}

}
