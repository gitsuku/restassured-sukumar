package tests;
import org.testng.Assert;

import io.restassured.*;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class validateStatus {
	void status() {
		RestAssured.baseURI="";
		RequestSpecification rs = RestAssured.given();
		Response response = rs.request(Method.GET, "");
		int statusCode = response.getStatusCode();
		
		Assert.assertEquals(statusCode, 200);
		Assert.assertEquals(response.body(), true);
		
		Headers allheaders = response.headers();
		for(Header  h : allheaders ) {
			Assert.assertEquals(h.getName(), true);
		}
		
		
		
	}
	

}
