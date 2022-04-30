package com.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class PathParamTest {
	
	@Test
	public void pathParam() {
		given()
		.pathParam("projectId","TY_PROJ_2203")
		.delete("http://localhost:8084/projects/{projectId}")
	   .then()
	     .log().all()
	     .assertThat().statusCode(204)
	     .assertThat().contentType(ContentType.JSON);
	}

}
