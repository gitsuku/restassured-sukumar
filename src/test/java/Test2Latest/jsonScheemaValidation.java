package Test2Latest;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import org.apache.tools.ant.taskdefs.condition.Matches;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class jsonScheemaValidation {
	@Test
	public void validate () {
		baseURI ="https://reqres.in/api";
		given().get("/users?page=2").then().assertThat().body(matchesJsonSchemaInClasspath( "scheema.json")).statusCode(200);
			
	}
}
