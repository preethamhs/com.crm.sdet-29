package com.rmgYantra.DifferentWayPostResource;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class CreateWebResourceUsingFileTest {
	
	@Test
	public void createWebResourceUsingFile() {
		File file=new File("./src/test/resources/File.json");
		given()
		     .body(file)
		     .contentType(ContentType.JSON)
		     .post("http://localhost:8084/addProject")
		.then()
		.assertThat().statusCode(201)
		.assertThat().contentType(ContentType.JSON);
	}

}
