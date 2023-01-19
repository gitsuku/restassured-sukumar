package Test2Latest;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
public class postTc_2 {
	
@Test
	void registration() {
		baseURI ="https://reqres.in";
		RequestSpecification rs =  RestAssured.given();
		//create body
		
		//request payload sending along with post request
		JSONObject requestParms = new JSONObject();
		requestParms.put("FirstName", "sukumar");
		requestParms.put("LasstName", "Nallam");
		requestParms.put("UsertName", "suku");
		requestParms.put("Password", "1234");
		
		rs.header("Content-type", "application/json" );
		rs.body(requestParms.toJSONString());
		
		Response response = rs.request(Method.POST, "/api/users");
		String responseBody = response.getBody().asString();
		System.out.println("body " +responseBody);
int statusCode = response.getStatusCode();
Assert.assertEquals(statusCode, 201);

//String successCode = response.jsonPath().get("SuccessCode");

//success code validation
//Assert.assertEquals(successCode, "OPERATION_SUCCESS");


	}
}
