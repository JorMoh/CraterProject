package tests_API;
import static org.hamcrest.Matchers.equalTo;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.io.File;
import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import utils.DButils;

public class IntegrateUpdateCustomer {
	@BeforeMethod
	public void setup() {
		RestAssured.baseURI = "http://invoice.primetech-apps.com/api";
	}

	@Test
	public void verifyStatusCode() {
//		END POINT: baseurl/v1/customers/<id>
//		Headers:
//		Authorization | Bearer <Token value> 
//		Content Type | application/json 
//		Accept | application/json
//		Company | 1
//
//		REQUEST BODY:
//		{
//	    "name": "Mohammad",
//	    "email": "mmohaidat@gmail.com",
//	    "password": "Supakan",
//	    "companies": [
//	        {
//	            "id": "1",
//	            "role": "vel"
//	        }
//	    ]
//	}

		File requestBody = new File("./src/test/resources/JSonTestData/updateCustomer.json");

		//Send a PUT valid request to /updatecustomer API.
		Response response = RestAssured
				.given().contentType("application/json").accept(ContentType.JSON)
				.header("Authorization", "Bearer 166|PYchM6Ahxi6Laj7N0TEFoCHXVwm9nxTIPskZ4wwh")
				.header("company", "1")
				.when().body(requestBody).put("/v1/customers/191");
				
		//verify status code is 200
		response.then()
		.assertThat().statusCode(200);
		
	}
	
	@Test
	public void verifyCustomerUpdate() {
		DButils db = new DButils();
		//verify the customer is updated in the database
		List<String> dataRecord =   db.selectArecord("select * from customers where name = 'Mohammad1'");
		 Assert.assertEquals(dataRecord.get(2), "Mohammad1");
	}
}
