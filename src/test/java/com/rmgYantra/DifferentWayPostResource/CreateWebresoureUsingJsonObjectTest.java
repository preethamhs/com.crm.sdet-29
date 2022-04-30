package com.rmgYantra.DifferentWayPostResource;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateWebresoureUsingJsonObjectTest {
	@Test
	public void createWebresoureUsingJsonObjectTest() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","avenger");
		jobj.put("projectName","capt");
		jobj.put("status","On going");
		jobj.put("teamSize",12);
		
		given()
		      .body(jobj)
		      .contentType(ContentType.JSON)
		      .post("http://localhost:8084/addProject")
		.then()
		      .log().all()
		      .assertThat().statusCode(201)
		      .assertThat().contentType(ContentType.JSON);
		
	}

}
