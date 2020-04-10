import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;

public class TC007_GET_REQUEST_AUTHROZITION {
	
	
	
	
	@Test
	public void Authorization()
	
	{
		//Specify the base URI, 
		
		RestAssured.baseURI="http://restapi.demoqa.com/authentication/CheckForAuthentication";
		
		// Basic Authentication
		
		PreemptiveBasicAuthScheme authscheme= new PreemptiveBasicAuthScheme();
		
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		
		RestAssured.authentication=authscheme;
				
		// Request Object for sending request
		RequestSpecification httprequest= RestAssured.given();
		Response response= httprequest.request(Method.GET,"/");
		
		// status code verification
		
		int statuscode= response.getStatusCode();
		System.out.println(statuscode);
		Assert.assertEquals(statuscode, 200);
				
		
		
	}

}
