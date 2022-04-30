package com.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class RequestChainingTest {
	
	@Test
	public void requestChaining() {
		Response response = when()
		  .get("http://localhost:8084/projects");
		   String actProID = response.jsonPath().get("[0].projectId");
		given()
		      .pathParam("projectId", actProID)
		 .when()
		       .delete("http://localhost:8084/projects/{projectId}")
		 .then()
		       .log().all()
		       .assertThat().statusCode(204)
		       .assertThat().contentType(ContentType.JSON);
	}

}
