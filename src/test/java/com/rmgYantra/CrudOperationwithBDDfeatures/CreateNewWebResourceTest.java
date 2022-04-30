package com.rmgYantra.CrudOperationwithBDDfeatures;

import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateNewWebResourceTest {
	
	@Test
	public void createNewWebResourceTest() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","avenger");
		jobj.put("projectName","captain");
		jobj.put("status","Completed");
		jobj.put("teamSize",12);
		
		given()
		      .body(jobj)
		      .contentType(ContentType.JSON)
		      .post("http://localhost:8084/addProject")
		.then()
		      .log().all()
		      .assertThat().statusCode(201)
		      .assertThat().contentType(ContentType.JSON)
		      .assertThat().time(Matchers.lessThan(200L));
		    
	}

}
