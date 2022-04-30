package com.rmgYantra.DifferentWayPostResource;

import java.util.HashMap;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateWebResourceUsingHashMapTest {

	@Test
	public void createWebResourceUsingHashMap() {
		HashMap jobj=new HashMap();
		jobj.put("createdBy","avenger");
		jobj.put("projectName","ca");
		jobj.put("status","On Going");
		jobj.put("teamSize",58);
		
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
