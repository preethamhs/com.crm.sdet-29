package com.rmgYantra.CrudOperationwithBDDfeatures;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CompleteUpdationTest {
	
	@Test
	public void completeUpdationTest() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","avenger");
		jobj.put("projectName","captain");
		jobj.put("status","On Going");
		jobj.put("teamSize",58);
		
		given()
		      .body(jobj)
		      .contentType(ContentType.JSON)
		      .put("http://localhost:8084/projects/TY_PROJ_1404")
		.then()
		      .log().all()
		      .assertThat().statusCode(200)
		      .assertThat().contentType(ContentType.JSON);
	}

}
