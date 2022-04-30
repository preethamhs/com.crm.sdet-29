package com.Validations;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class StaticValidationUsingJsonPathTest {
	
	@Test
	public void validationUsingJsonPath() {
		String ExpectedProjName = "HDFC1";
		Response response = when()
		     .get("http://localhost:8084/projects");
		String actProjName = response.jsonPath().get("[2].projectName");
		
		Assert.assertEquals(actProjName, ExpectedProjName);
		     
	}

}
