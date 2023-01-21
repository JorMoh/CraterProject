package tests_API;

import java.io.File;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.DButils;

public class IntegrateCreateCustomer {
	
  @BeforeMethod
  public void setup() {
	  RestAssured.baseURI = "http://invoice.primetech-apps.com/api";
	  
  }
	
  @Test
  public void verifyStatusCode() {
//	  END POINT: http://invoice.primetech-apps.com/api/
//
//	  HEADERS:
//	  Authorization | Bearer <Token value> 
//	  Content Type | application/json 
//	  Accept | application/json
//	  Company | id of company
	  File requestBody = new File("./src/test/resources/JSonTestData/createUser.json");
	  
	//send a request to the "Create customer API" with the ‘POST’ HTTP method,
	  Response response = RestAssured
			  .given().contentType("application/json").accept(ContentType.JSON)
			  .header("Authorization", "Bearer 166|PYchM6Ahxi6Laj7N0TEFoCHXVwm9nxTIPskZ4wwh")
			  .header("company", "1")
			  .when().body(requestBody).post("/v1/customers");
      //verify status code is 200
	  response.then()
	  .assertThat().statusCode(200);
	 
	  
  }
  
  @Test
  public void verifyCustomerCreated() {
	  DButils db = new DButils();
	//verify the customer is created in the database
	List<String> dataRecord =   db.selectArecord("select * from customers where name = 'Mohammad Mostafa'");
	 Assert.assertEquals(dataRecord.get(2), "Mohammad Mostafa");
	  
  }
}
