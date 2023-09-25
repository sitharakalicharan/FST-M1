package project;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

import java.util.HashMap;
import java.util.Map;

import org.testng.Reporter;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class GithubProject {
	
	RequestSpecification request_spec;
	int ssh_id;
	String ssh = "ssh-ed25519 AAAAC3NzaC1lZDI1NTE5AAAAIJ053IsX6OF+Li/lTuwX0jUJAT0Tn8I3zvgJADr2DKuW";
	
	@BeforeClass
	public void setup() {
		
		request_spec = new RequestSpecBuilder()
				.setContentType(ContentType.JSON)
				.addHeader("Authorization", "Bearer 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")
				.setBaseUri("https://api.github.com").build();
		
	}
	
	@Test(priority=1)
	public void add_token() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("title", "TestAPIKey");
		map.put("key", ssh);
		
		Response response = given().spec(request_spec)
				.body(map)
				.when().post("/user/keys");
		
		response.then().statusCode(201);
		
		
		ssh_id = response.body().path("id");	
	}
	
	@Test(priority= 2)
	public void get_ssh() {
		
		Response response = given().spec(request_spec)
				.pathParam("keyId", ssh_id)
				.when().get("/user/keys/{keyId}");
		
		Reporter.log(response.body().asPrettyString());
		
		response.then().statusCode(200);
		
	}
	
	@Test(priority = 3)
	public void delete_ssh() {
		
		Response response = given().spec(request_spec)
				.pathParam("keyId", ssh_id)
				.when().delete("/user/keys/{keyId}");
		
		Reporter.log(response.body().asPrettyString());
		
		response.then().statusCode(204);
	}
	
	
	
	

}
