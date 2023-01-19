package Test2Latest;
import static io.restassured.RestAssured.baseURI;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class authCheck {
	

	@Test
		void authenticationCheck() {
			baseURI = "https://reqres.in";
			//need to specify authentication before request
			PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
			auth.setUserName("");
			auth.setPassword("");
			//specify the authentication type
			RestAssured.authentication= auth;
			RequestSpecification rs = RestAssured.given();
			Response response = rs.request(Method.GET,"/api/unknown/23" );
			/*
			 * String rBody = response.getBody().asString(); //System.out.println(rBody);
			 * Assert.assertEquals(rBody.contains("Janet"), false);
			 */
	
			int sCode = response.getStatusCode();
			Assert.assertEquals(sCode, 200);
			
	
}
	void t() {
		baseURI = "https://reqres.in";
		//need to specify authentication before request
	RequestSpecification rs = RestAssured.given();
	Response res = rs.request(Method.GET, "/path");
	
		
		
		
		
		
		
		
		
	}
}
