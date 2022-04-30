package rmgYantra.CRUDoperation;

import java.util.concurrent.TimeUnit;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class CreateNewResourceTest {
	@Test
	public void createNewResource() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","tokio");
		jobj.put("projectName","thor-1");
		jobj.put("status","Completed");
		jobj.put("teamSize",12);
		
		RequestSpecification respec = RestAssured.given();
		respec.body(jobj);
		respec.contentType(ContentType.JSON);
		Response response = respec.post("http://localhost:8084/addProject");
	     ValidatableResponse validate = response.then();
	  
		
		validate.assertThat().statusCode(201);
		validate.assertThat().contentType(ContentType.JSON);
		
		//validate.log().all();
	}

}
