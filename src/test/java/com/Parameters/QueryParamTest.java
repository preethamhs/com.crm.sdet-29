package com.Parameters;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class QueryParamTest {
	
	@Test
	public void queryParam() {
		given()
		     .queryParam("page","2")
		.when()     
		     .get("https://reqres.in/api/users")
		.then()
		     .log().all()
		     .assertThat().statusCode(200)
		     .assertThat().contentType(ContentType.JSON);
	}

}
