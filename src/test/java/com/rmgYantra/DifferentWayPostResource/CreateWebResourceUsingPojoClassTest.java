package com.rmgYantra.DifferentWayPostResource;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import com.rmgYantra.pojoclasses.PojoClass;

import io.restassured.http.ContentType;

public class CreateWebResourceUsingPojoClassTest {
	
	@Test
	public void createWebResourceUsingPojoClass() {
		PojoClass pobj=new PojoClass("ghy", "ljajshg", "On Going", 10);
		
		given()
	      .body(pobj)
	      .contentType(ContentType.JSON)
	      .post("http://localhost:8084/addProject")
	.then()
	      .log().all()
	      .assertThat().statusCode(201)
	      .assertThat().contentType(ContentType.JSON);
	}

}
