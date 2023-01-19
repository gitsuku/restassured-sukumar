package Test2Latest;

import static io.restassured.RestAssured.baseURI;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.excelutils;

public class postWithDataprovider {
	@Test(dataProvider ="empdataProvider")
	void postWirhDataProvider(String ename, String eage, String esal) {
		baseURI = "http://dummy.restapiexample.com/api/v1";
		RequestSpecification rs = RestAssured.given();
		JSONObject reqParms = new JSONObject();
		reqParms.put("Name", ename);
		reqParms.put("age", eage);
		reqParms.put("salary", esal);
		//adding the header stating the request body is json
		rs.header("Content-Type", "application/json");
		rs.body(reqParms.toJSONString());
		Response response = rs.request(Method.POST, "/create");

		String responseBody = response.getBody().asString();
		Assert.assertEquals(responseBody.contains(ename), true);
		Assert.assertEquals(responseBody.contains(eage), true);
		Assert.assertEquals(responseBody.contains(esal), true);
		int statusCode = response.getStatusCode();
		Assert.assertEquals(statusCode, 200);
	}
	
	
	@DataProvider(name= "empdataProvider")
	String  [] []getData() throws Exception{
		String path = "C:\\Users\\JAICHANDRAN\\eclipse-workspace\\RestAPIProject\\src\\test\\java\\datasheets\\testdata1.xlsx";
		int rowcout = excelutils.getRowCount(path, "sheet1");
		int colomCount = excelutils.getCellCount(path, "sheet1", 1);
		String empData [] [] = new String[rowcout] [colomCount] ;
		for(int i =1; i<=rowcout; i++) {
			for(int j =0; j<colomCount; j++) {
				empData[i-1][j]= excelutils.getCellData(path, "sheet1", i, j) ;
			}
		}
		
		//String empData[] [] = {{"sukumar", "28", "30lac"},{"raj", "30", "20lac"},{"sam","23","14las"}};
		return (empData);
		
	}
	
	
}
