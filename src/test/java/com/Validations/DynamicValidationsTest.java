package com.Validations;

import org.testng.annotations.Test;

import com.rmgYantra.pojoclasses.PojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.concurrent.TimeUnit;

public class DynamicValidationsTest {
	
	@Test
	public void validations() {
		PojoClass obj=new PojoClass("ml", "po", "completed", 20);
		Response response = given()
		  .body(obj)
		  .contentType(ContentType.JSON)
		  .post("http://localhost:8084/addProject");
		Object projectName = response.getBody().path("projectName");
		
		response.jsonPath().get("projectId");
		
		//Time
		response.getTime();
		response.getTimeIn(TimeUnit.SECONDS);
		
		response.time();
		response.timeIn(TimeUnit.SECONDS);
		
		
		
	}

}
