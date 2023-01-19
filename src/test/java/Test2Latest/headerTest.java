package Test2Latest;
import static io.restassured.RestAssured.*;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class headerTest {
	RequestSpecification rs;
	Response response;
	@BeforeClass
	void main() {
		baseURI = "https://reqres.in";
		rs = RestAssured.given();
	}
	@Test(enabled = false)
	void getheaders() {
		
		 response = rs.request(Method.GET,".in/" );
		Headers allheader = response.headers();
		for(Header h : allheader) {
			System.out.println(h.getName() +"  "+h.getValue());
		}
	}
	@Test(enabled = false)
		void jsonResponseValidate() {
			
			 response = rs.request(Method.GET,"/api/users/2" );
			String rBody = response.getBody().asString();
			//System.out.println(rBody);
			Assert.assertEquals(rBody.contains("Janet"), false);		
	}
	@Test(priority=0)
	void extraxtValueEachNote() {
		
		 response = rs.request(Method.GET,"/api/unknown/2" );
		String rBody = response.getBody().asString();
		Assert.assertEquals(rBody.contains("Janet"), false);
		JsonPath path = response.jsonPath();
		System.out.println(path.get("color"));
		
}
	void t() {

		PreemptiveBasicAuthScheme auth = new PreemptiveBasicAuthScheme();
		auth.setUserName("");
		auth.setPassword("");
		RestAssured.authentication = auth;
		 rs = RestAssured.given();
		 response = rs.request(Method.GET, "/user");
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	void t2() {
		
		 rs = RestAssured.given();
		 response = rs.request(Method.GET, "");
		String body = response.body().asString();
		JsonPath j = response.jsonPath();
	}
	
}
