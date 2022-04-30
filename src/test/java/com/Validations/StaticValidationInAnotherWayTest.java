package com.Validations;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class StaticValidationInAnotherWayTest {
	@Test
	public void validations() {
		when()
		    .get("http://localhost:8084/projects")
	    .then()
	        .assertThat().statusCode(200)
	        .assertThat().contentType(ContentType.JSON)
	        .log().all();
	}

}
