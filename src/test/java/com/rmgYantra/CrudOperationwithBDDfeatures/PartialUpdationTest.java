package com.rmgYantra.CrudOperationwithBDDfeatures;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PartialUpdationTest {
	
	@Test
	public void partialUpdationTest() {
		JSONObject obj=new JSONObject();
		obj.put("name","thor");
		obj.put("job","engineer");
		
		given()
		     .body(obj)
		     .contentType(ContentType.JSON)
		     .patch("https://reqres.in/api/users/2")
		.then()
		      .log().all()
		      .assertThat().statusCode(200)
		      .assertThat().contentType(ContentType.JSON);		
	}

}
