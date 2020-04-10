import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC0006_GET_REQUEST_VALIDATE_ALL_THE_RESPONSE {
	
	
	
	
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
	
	// From the response we will extract the JSON
	
	JsonPath jsonpath= response.jsonPath();
	
	// Now from the jsonpath we will ge  the value of each key/variable.

	System.out.println(jsonpath.get("City"));
	System.out.println(jsonpath.get("Temprature"));
	System.out.println(jsonpath.get("Humidity"));
	System.out.println(jsonpath.get("WindSpeed"));
	
	Assert.assertEquals(jsonpath.get("City"), "Delhi");	
	
}	

}
