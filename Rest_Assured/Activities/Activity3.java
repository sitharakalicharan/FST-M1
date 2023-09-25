package activities;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;


import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Activity3 {
	
	RequestSpecification requestSpec;
	ResponseSpecification respSpec;
	
	@BeforeClass
	public void setup() {
		
		requestSpec = new RequestSpecBuilder().setContentType(ContentType.JSON)
				.setBaseUri("https://petstore.swagger.io/v2/pet")
				.build();
		
		respSpec = new ResponseSpecBuilder().expectStatusCode(200)
				.expectContentType(ContentType.JSON)
				.build();
	}
	
	@DataProvider
	public Object[][] data(){
		
		Object[][] test_data = new Object[][] {
			{ 98798, "bunty", "alive" }, 
            { 541111, "simba", "alive" }
		};
		return test_data;
		
	}
	
	@Test(priority=1)
	public void test_post() {
		
		System.out.println("--------Post request---------");
		String reqBody = "{\"id\": 98798, \"name\": \"bunty\", \"status\": \"alive\"}";
        Response response = given().spec(requestSpec) 
                .body(reqBody) 
                .when().post(); 
 
        reqBody = "{\"id\": 541111, \"name\": \"simba\", \"status\": \"alive\"}";
        response = given().spec(requestSpec)
                .body(reqBody) 
                .when().post(); 
 
        
        response.then().spec(respSpec);
        response.then().log().all();
	}
	
	
	@Test(dataProvider = "data", priority = 2)
	public void test_get(int petid, String petname, String availability) {
		System.out.println("--------Get request---------");
		Response response = given().spec(requestSpec).when().pathParam("petId", petid)
				.get("/{petId}");
		
		response.then().log().all();
		response.then().spec(respSpec).body("name", equalTo(petname));
		
		
		
	}
	
	@Test(dataProvider = "data", priority = 3)
	public void test_delete(int petid, String petname, String availability) {
		System.out.println("--------Delete request---------");
		Response response = given().spec(requestSpec).pathParam("petId", petid)
				.delete("/{petId}");
		
		response.then().log().all();
		response.then().spec(respSpec).body("message", equalTo(Integer.toString(petid)));
		
		
		
	}
	
	
	
	
	

}
