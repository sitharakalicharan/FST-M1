package activities;


import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
public class Activity2 {
	
	final static String base_uri = "https://petstore.swagger.io/v2/user";
	
	
	@Test(priority = 1)
	public void post_new_user() throws IOException {
		
		FileInputStream inputJson = new FileInputStream("src/test/java/activities/userinfo.json");
		
		String request = new String(inputJson.readAllBytes());
		
		Response response = given().contentType(ContentType.JSON).body(request)
				.when()
				.post(base_uri);
		
		response.then().log().all();
		response.then().statusCode(200);
		response.then().body("message", equalTo("83356"));
		
	}
	
	@Test(priority = 2)
	public void get_user() {
		
		File outputJson = new File("src/test/java/activities/userGETResponse.json");
		
		
		Response response = given().contentType(ContentType.JSON)
		.pathParam("username", "anastasia").when()
		.get(base_uri+"/{username}");
		
		response.then().log().all();
		
		String response_body = response.body().asPrettyString();
		
		try {
		outputJson.createNewFile();
		FileWriter writer = new FileWriter(outputJson.getPath());
		writer.write(response_body);
		writer.close();
		}
		catch(IOException excp){
			excp.printStackTrace();
		}
		
		response.then().body("id", equalTo(83356));
        response.then().body("username", equalTo("anastasia"));
        response.then().body("firstName", equalTo("Justin"));
        response.then().body("lastName", equalTo("Case"));
        response.then().body("email", equalTo("justincase@mail.com"));
        response.then().body("password", equalTo("password123"));
        response.then().body("phone", equalTo("9812763450"));
	}
	
	@Test(priority = 3)
	public void delete_user() {
		
		Response response = given().contentType(ContentType.JSON)
				.pathParam("username", "anastasia")
				.when().delete(base_uri+ "/{username}");
		
		response.then().log().all();
		response.then().statusCode(200);
		response.then().body("message", equalTo("anastasia"));	
		
	}

}
