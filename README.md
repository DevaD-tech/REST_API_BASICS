API / Web Services Testing using RestAssured

Setup:

Created a maven project
Update the pom.xml with the following dependencies
RestAssured
Apache POI
Json simple
testNG


GET REQUEST

 TC001
Have sent some request >> get the response >> get the response body >> validated the response code and statusline


Created a void method: void getrequestdetails()
Specify the baseURI : from the API documentation
Create request object: so when ever we want to make any request we will use this object

Ex: RequestSpecification httprequest= RestAssured.given();

Create response object : once we make a request it will give a response so in order to store the response we will create a response object.

Ex: Response response= httprequest.request(Method.GET,"/Hyderabad");


With the httprequest object we made a GET request to the server with the path parameter, it gave the response and the response stored in response variable,
From the response get the response body, convert the body in string and store the value in a string type variable responsebody.

String responsebody=response.getBody().asString();





Now lets print the responsebody
        
System.out.println("Response body is:"+responsebody);




Validation Part:


From the response get the get the status code , store that status code in an integer type variable and then print it.


int statuscode=response.getStatusCode();
System.out.println("Status code is: "+statuscode);

We have captured the status code from response now we will validate it using assert command.
Assert.assertEquals(statuscode, 200);

Lets capture the status line from the response and store it in a string variable and then print it and validate it using assert command.

String statusline=response.getStatusLine();
	System.out.println("Status line is: "+statusline);
	Assert.assertEquals(statusline, "HTTP/1.1 200 OK");

		
POST REQUEST
TC002

Created a post request >> created body >> specified the content type >> verified the status code >> sucess code verification

Created a void method: void getrequestdetails()

Specify the baseURI : from the API documentation
RestAssured.baseURI="http://restapi.demoqa.com/customer";



Create request object: so when ever we want to make any request we will use this object.

RequestSpecification httprequest= RestAssured.given();

Now we will create payload which we will be sending along with the POST request.
Payload and the header need to go with the POST request.



JSONObject requestParams= new JSONObject();
		
requestParams.put("FirstName", "Devesh");
requestParams.put("LastName", "Kumar_1");
requestParams.put("UserName", "UserName_1");
requestParams.put("Password", "Devesh123");
requestParams.put("Email", "Devesh@gmail.com");
		
//header
httprequest.header("Content-Type","application/json");

// sending json to the body	
httprequest.body(requestParams.toJSONString());

Sending POST request to the DB, httprequest already contains the required body

Response response= httprequest.request(Method.POST,"/register");


Validation Part:

Now lets print the responsebody
        
System.out.println("Response body is:"+responsebody);

From the response get the get the status code , store that status code in an integer type variable and then print it.

int statuscode=response.getStatusCode();
System.out.println("Status code is: "+statuscode);



From the response get the get the status code , store that status code in an integer type variable and then print it.

int statuscode=response.getStatusCode();
System.out.println("Status code is: "+statuscode);

We have captured the status code from response now we will validate it using assert command.
Assert.assertEquals(statuscode, 201);

// Success code validation (success code from the API document)
		
String successcode= response.jsonPath().get("SuccessCode");
Assert.assertEquals(successcode, "OPERATION_SUCCESS");


GET REQUEST
TC003

Validate the header of the google API

Created a void method: void getrequestdetails()
Specify the baseURI : from the API documentation
Create request object: so when ever we want to make any request we will use this object

Ex: RequestSpecification httprequest= RestAssured.given();

Create response object : once we make a request it will give a response so in order to store the response we will create a response object.

Ex: Response response= httprequest.request(Method.GET,"/Hyderabad");

With the httprequest object we made a GET request to the server with the path parameter, it gave the response and the response stored in response variable,
From the response get the response body, convert the body in string and store the value in a string type variable responsebody and print the body.

String responsebody=response.getBody().asString();
System.out.println("Response body is:"+responsebody);

Now we will capture the details of headers from response.

String contentType= response.getHeader("Content-Type");

System.out.println("Content Type is: "+contentType);

validating the header

Assert.assertEquals(contentType, "application/xml; charset=UTF-8");

GET REQUEST
TC004

Get all the header from the response 
 
After printing the response body we will get all the headers from the response and will store all the headers in a variable ‘allheaders’ of type Headers

Headers allheaders= response.headers();

Using FOR loop we will read all the headers and will store the header in variable named header of type Header.
The variable will contain the header in the form of key value, so will will extract the name and value and will print them.

for(Header header:allheaders)

System.out.println(header.getName()+      header.getValue() );
		
//System.out.println(header.getValue());


GET REQUEST
TC005

Verify/Validate the Response Body

After printing the response we will now validate using the Assert command.

Assert.assertEquals(responsebody.contains("Delhi"), "Delhi");





GET REQUEST
TC006

Validate all the values from the response.
We will extract the values from the response in the form of json,using jsonpath object we can extract all the values and can verify the each value using Assert command.

JsonPath jsonpath= response.jsonPath();

Now from the jsonpath we will ge  the value of each key/variable.

System.out.println(jsonpath.get("City"));
	System.out.println(jsonpath.get("Temprature"));
	System.out.println(jsonpath.get("Humidity"));
	System.out.println(jsonpath.get("WindSpeed"));

Assert.assertEquals(jsonpath.get("City"), "Delhi");	

GET REQUEST
TC007

GET REQUEST with Authorization

Authentication should be specified before sending the request

 
PreemptiveBasicAuthScheme authscheme= new PreemptiveBasicAuthScheme();
		
		authscheme.setUserName("ToolsQA");
		authscheme.setPassword("TestPassword");
		RestAssured.authentication=authscheme;




