package nov_2022;

import java.io.File;

import com.google.common.io.Files;

import Test2Latest.postRequesrt2;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class fileUpload_Demo {
	public void upload() {
		File file = new File("");
		Response response = RestAssured.given().multiPart("file", file, "multipart/form-data").post("endpoint").thenReturn();
		
	}
	public void download() {
		
		Response response = RestAssured.given().log().all().when().get("endpoint").andReturn();
		
		byte[] bytes =  response.getBody().asByteArray();
				File file = new File("downloadLocation");
				Files.write(file.toPath(), bytes);
	}
}
