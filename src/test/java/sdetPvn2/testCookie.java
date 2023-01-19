package sdetPvn2;
import static io.restassured.RestAssured.*;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.response.Response;

//cookie valu always get changed, we can validate cookie names not values
public class testCookie {
	//@Test(priority = 1)
	void cockieTest(){
		given()
		.when().get("https://www.google.com/").then().cookie("AEC" ,"adr").log().all();
	}
	@Test(priority = 2)
	void test2() {
		Response res =given().when().get("https://www.google.com/");
		
		String cookie_value = res.getCookie("AEC");
		System.out.println("cookie value is == "+cookie_value);
		
		//get all cookies
		Map<String,String> allcookies = res.getCookies();
		System.out.println(allcookies.keySet());
		for(String k : allcookies.keySet()) {
			String k_val = res.getCookie(k);
			System.out.println(k +"      "+k_val);
		}
		
	}
}
