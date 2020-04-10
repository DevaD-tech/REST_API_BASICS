import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC002_POST_REQUEST {
	
	
	
@Test
	
	void RegistrationSuccessfulls()
	{

		//Specify the base URI, 
		
		RestAssured.baseURI="http://restapi.demoqa.com/customer";
		
		
		// Request Object for sending request
		RequestSpecification httprequest= RestAssured.given();
		
		// Response Object
		// Request payload sending along with the POST request
		
		JSONObject requestParams= new JSONObject();
		
		requestParams.put("FirstName", "Devesh1XYZ1");
		requestParams.put("LastName", "Kumar_1XW");
		requestParams.put("UserName", "UserNameRESR_1");
		requestParams.put("Password", "Devesh123");
		requestParams.put("Email", "Devesh6545DSA@gmail.com");
		
		//header
		httprequest.header("Content-Type","application/json");
		
		// sending json to the body
		
		httprequest.body(requestParams.toJSONString()); // attach data to the request
		
		Response response= httprequest.request(Method.POST,"/register");
		
		
		// print the response
		
		String responsebody=response.getBody().asString();
		
		System.out.println("Response body is:"+responsebody);
		
		// Printing the status code
		
		int statuscode=response.getStatusCode();
		
		// Verify the status code
		
		System.out.println("Status code is: "+statuscode);
		Assert.assertEquals(statuscode, 201);
	
		// Success code validation
		
		String successcode= response.jsonPath().get("SuccessCode");
		Assert.assertEquals(successcode, "OPERATION_SUCCESS");
		
		
		
		
	}

}
