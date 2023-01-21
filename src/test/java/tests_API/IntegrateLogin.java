package tests_API;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.hamcrest.Matchers.equalTo;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IntegrateLogin {
	
  @BeforeMethod
  public void setup() {
	  RestAssured.baseURI = "http://invoice.primetech-apps.com/api";
  }
  @Test
  public void verifyLogin() {
	  
//	  END POINT: baseurl/v1/auth/login
//	  Headers:
//	  Content Type | application/json 
//	  Company | id of company
//
//	  Request Body:
//
//	  {
//	      "username": "m.mohaidat877@gmail.com",
//	      "password": "Test1234",
//	      "device_name":"mobile_app"
//	  }
	  
	  //Send a post request to the "LOGIN" API.
	  Response response = RestAssured
			  .given().accept(ContentType.JSON).contentType("application/json")
			  .header("company", "1")
			  .when().body("{\n"
			  		+ "	      \"username\": \"m.mohaidat877@gmail.com\",\n"
			  		+ "	      \"password\": \"Test1234\",\n"
			  		+ "	      \"device_name\":\"mobile_app\"\n"
			  		+ "	  }").post("/v1/auth/login");
			  response.prettyPrint();
	  //verify status code is 200
	  response.then()
	  .assertThat().statusCode(200)
	  //verify the response body: { "type": "Bearer", "token": "the token generated" }
	  .and().body("type", equalTo("Bearer"));
	  
  }
  
  
}
