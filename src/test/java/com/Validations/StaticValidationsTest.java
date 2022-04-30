package com.Validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticValidationsTest {
	@Test
	public void staticValidationsTest() {
		String ExpContentType = "application/json";
		int ExpStatusCode=200;
		
	   Response response = when()
	       .get("http://localhost:8084/projects");
	   String actualContentType = response.getContentType();
	   int actStatusCode = response.getStatusCode();
	   
	   Assert.assertEquals(ExpContentType, actualContentType);
	   Assert.assertEquals(ExpStatusCode,actStatusCode);
	       
	}

}
