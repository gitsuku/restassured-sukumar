package sdetPvn3;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;

public class fileUpload_download {
	
	void uploadSingleFile() {
		
		File myFile = new File(" ");
		given().multiPart("file",myFile)
		.contentType("multiPart/form-data")
		.when()
		.post("path")
		.then()
			.statusCode(200)
			.body("filename", equalTo("test.txt"));
		
	}
	
void upload2File() {
		
		File myFile1 = new File(" ");
		File myFile2 = new File(" ");
		given().multiPart("files",myFile1)
		.multiPart("files",myFile2)
		.contentType("multiPart/form-data")
		.when()
		.post("path")
		.then()
			.statusCode(200)
			.body("[0].filename", equalTo("test1.txt"))
			.body("[1].filename", equalTo("test2.txt"));
		
	}

//this will work based on designe by developer
void uploadMultipleFile() {
	
	File myFile1 = new File(" ");
	File myFile2 = new File(" ");
	File myFile3 = new File(" ");
	File filesArr[] = {myFile1,myFile2,myFile3};
	
	given().multiPart("files",filesArr)
	
	.contentType("multiPart/form-data")
	.when()
	.post("path")
	.then()
		.statusCode(200)
		.body("[0].filename", equalTo("test1.txt"))
		.body("[1].filename", equalTo("test2.txt"));
	
}

}
