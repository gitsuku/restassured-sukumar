package nov_2022;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class authenticaton_Demo {
	@Test
	public void oauth2Demo() {
		Response response = RestAssured.given().auth().oauth2("accessToken").get("path")
				.andReturn();
		String link = response.jsonPath().getString("data.link");
	}
	public void basic() {
		RequestSpecification httpRequest = RestAssured.given().auth().basic("postman", "password"); 
	       Response res = httpRequest.get("https://postman-echo.com/basic-auth");
	       ResponseBody body = res.body();
	       //Converting the response body to string
	       String rbdy = body.asString();
	       System.out.println("Data from the GET API- "+rbdy);	}
	

}
