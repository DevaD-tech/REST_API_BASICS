import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC005_GET_VALIDATE_JSON_RESPONSE {
	
	
	
@Test

public void googlemaptest()
{

	//Specify the base URI, 
	
	RestAssured.baseURI="http://restapi.demoqa.com/utilities/weather/city";
	
	
	// Request Object for sending request
	RequestSpecification httprequest= RestAssured.given();
	
	// Create Response Object, with the httprequest object we made a GET request to the server with the path 
	//parameter, it gave the response and the response stored in response variable
	
	Response response= httprequest.request(Method.GET,"/Delhi");
	
	// print the response
	
	String responsebody=response.getBody().asString();
	
	System.out.println("Response body is:"+responsebody);
	
	Assert.assertEquals(responsebody.contains("Delhi"),true);
	
	
	
}	
	

}
