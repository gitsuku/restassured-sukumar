package sdetPvn2;
import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
public class headersDemo {
//my comment on 9th dec 2023
		//@Test(priority = 1)
		void headerTest(){
			given()
			.when().get("https://www.google.com/").then().header("Content-Type", "text/html; charset=ISO-8859-1").header("Server", "gws");
			
		}
		
		@Test(priority = 1)
		void testAllHeaders() {
		Response response =	given()
			.when().get("https://www.google.com/");
		
		//get single header info
		String cType = response.getHeader("Content-Type");
		System.out.println(cType);
		
		//get all header info
		
	Headers all	=response.getHeaders();
	for(Header h : all) {
		System.out.println(h.getName() +"       "+h.getValue());
		System.out.printf("printing all headers");
	}
		
		}
}
