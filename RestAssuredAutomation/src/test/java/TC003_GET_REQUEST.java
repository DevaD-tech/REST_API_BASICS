import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TC003_GET_REQUEST {
	
	
	
@Test
	
	void googlemaptest()
	{

		//Specify the base URI, 
		
		RestAssured.baseURI="https://maps.googleapis.com";
		
		
		// Request Object for sending request
		RequestSpecification httprequest= RestAssured.given();
		
		// Create Response Object, with the httprequest object we made a GET request to the server with the path 
		//parameter, it gave the response and the response stored in response variable
		
		Response response= httprequest.request(Method.GET,"/maps/api/place/nearbysearch/xml?location=-33.8670522,151.1957362&radius=1500&type=supermarket&key=AIzaSyBjGCE3VpLU4lgTqSTDmHmJ2HoELb4Jy1s");
		
		// print the response
		
		String responsebody=response.getBody().asString();
		
		System.out.println("Response body is:"+responsebody);
		
		//capture details of header from the response and validating the header
		
		String contentType= response.getHeader("Content-Type");
		System.out.println("Content Type is: "+contentType);
		Assert.assertEquals(contentType, "application/xml; charset=UTF-8");
		
		
		
		
		
	}


}
