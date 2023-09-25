package activities;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Activity1 {
	
	final static String base_uri = "https://petstore.swagger.io/v2/pet";
	Integer pet_id;
	
	@Test(priority = 1)
	public void post_new_pet() {
		
		pet_id = 312345;
		String req = "{"
	            + "\"id\": 312345,"
	            + "\"name\": \"Riley\","
	            + " \"status\": \"alive\""
	        + "}";
		
		Response response = given().contentType(ContentType.JSON)
		.body(req).when().post(base_uri);
		
		
		response.then().body("id", equalTo(pet_id));
		response.then().body("name",equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
		
	}
	
	@Test(priority = 2)
	public void get_pet() {
		Response response = given().contentType(ContentType.JSON)
				.when().pathParam("petId", pet_id)
				.get(base_uri + "/{petId}");
		
		
		response.then().body("id", equalTo(pet_id));
		response.then().body("name", equalTo("Riley"));
		response.then().body("status", equalTo("alive"));
		
		
	}
	
	@Test(priority = 3)
	public void delete_pet() {
		Response response = given().contentType(ContentType.JSON)
				.when().pathParam("petId", pet_id).delete(base_uri + "/{petId}");
		
		response.then().body("code", equalTo(200));
		response.then().body("message", equalTo(Integer.toString(pet_id)));
	}

}
