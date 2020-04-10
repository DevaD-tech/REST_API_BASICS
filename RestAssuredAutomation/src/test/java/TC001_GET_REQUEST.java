

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC001_GET_REQUEST {
	
	
	
	@Test
	
	void getweatherdetails()
	{

		//Specify the base URI, 
		
		RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
		
		
		// Request Object for sending request
		RequestSpecification httprequest= RestAssured.given();
		
		// Create Response Object, with the httprequest object we made a GET request to the server with the path 
		//parameter, it gave the response and the response stored in response variable
		
		Response response= httprequest.request(Method.GET,"/Hyderabad");
		
		// print the response
		
		String responsebody=response.getBody().asString();
		
		System.out.println("Response body is:"+responsebody);
		
		// Printing the status code
		
		int statuscode=response.getStatusCode();
		
		// Verify the status code
		
		System.out.println("Status code is: "+statuscode);
		Assert.assertEquals(statuscode, 200);
	
		// GEt the statusline and Verify the status line
		
		String statusline=response.getStatusLine();
		System.out.println("Status line is: "+statusline);
		Assert.assertEquals(statusline, "HTTP/1.1 200 OK");
		
		
	}

}
