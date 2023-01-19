package nov_2022;

import static org.testng.Assert.assertEquals;

import java.util.List;

import org.testng.annotations.Test;

import com.fasterxml.jackson.annotation.JsonSubTypes.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jdk.internal.org.objectweb.asm.*;
import groovyjarjarasm.asm.TypeReference;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class serilaizeSource {
	private static final ObjectMapper MAPPER = new ObjectMapper();
	private static String url  = "https://reqres.in/api/users/2";
	SourcePojClass ob = new SourcePojClass();
	
	@Test(enabled = false)
	public void serilaizeDemo() throws JsonProcessingException {
		ob.setId(1);
		ob.setEmail("dummy@gmail");
		ob.setFirstName("sukumar");
		ob.setLastName("reddy");
		//String url = "https://reqres.in/api/users/2";
		
		//serilaizing 
		String json = MAPPER.writeValueAsString(ob);
		
		Response response = RestAssured.given().contentType("application/json")
				.log().all().body(json).post(url).andReturn();
		assertEquals(response.getStatusCode(), 201);
	}
	
	@Test
	public void DeserilaizeDemo() throws JsonProcessingException {
		SourcePojClass obj =  RestAssured.given().get(url).as(SourcePojClass.class);
		System.out.println(obj);
		
	}
	
	@Test
	public void DeserilaizeDemoList() throws JsonProcessingException {
		SourcePojClass obj =  RestAssured.given().get(url).as(SourcePojClass.class);
		System.out.println(obj);
		
		//Type type = new TypeReference<List<SourcePojClass>>()){}.getTy
		List<SourcePojClass> src = RestAssured.get(url).as(type);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
