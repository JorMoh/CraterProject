package tests_API;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class IntegrateLogout {
	
  @BeforeMethod
  public void setup() {
  RestAssured.baseURI = "http://invoice.primetech-apps.com/api";
	  }
  
  @Test
  public void verifyLogout() {
//	  END POINT: baseurl/v1/auth/logout

//	  HEADERS:
//	  Authorization | Bearer <Token value> 
//	  Content Type | application/json 
//	  Accept | application/json
//	  Company | id of 
	  
	  //Send a POST request to the Logout API.
	  Response response = RestAssured
			  .given().accept(ContentType.JSON).accept("application/json")
			  .header("Authorization", "Bearer 165|ClqWIDJrlhZNJX2Cr5MVdt9HxxaTxjApAQbbp1Sx")
			  .header("company", "1")
			  .when().post("/v1/auth/logout");
	  //verify status code is 200
	  response.then()
	  .assertThat().statusCode(200);
	  //verify the response body: { "success": true }
  }
}
