package com.rmgYantra.CrudOperationwithBDDfeatures;

import static org.junit.Assert.assertThat;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;



public class GetAllTheDataTest {

	@Test
	public void getAllTheData() {
		when()
		     .get("http://localhost:8084/projects")
		.then()
		.log().all()
		.assertThat().statusCode(200)
		.assertThat().contentType(ContentType.JSON);
		     
	}
}
