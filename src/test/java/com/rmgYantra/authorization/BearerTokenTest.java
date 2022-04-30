package com.rmgYantra.authorization;

import static io.restassured.RestAssured.given;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class BearerTokenTest {
	
	@Test
	public void bearerToken() {
			given()
			   .auth().oauth2("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")
			.when()
			   .get("https://api.github.com/user/repos")
			.then().log().all()
			.assertThat().statusCode(200)
			.assertThat().contentType(ContentType.JSON);

	}

}
