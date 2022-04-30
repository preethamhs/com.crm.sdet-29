package com.rmgYantra.authorization;

import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class Oauth2Test {
	
	@Test
	public void auth() {
		Response response = given()
		.formParam("client_id","App-1")
		.formParam("client_secret","6054f0e591ca8e4abe3ddeb3e486e226")
		.formParam("grant_type","client_credentials")
		.formParam("redirect_uri","	https://example.com")
		.post("http://coop.apps.symfonycasts.com/token");
		String accessToken = response.jsonPath().get("access_token");
		
		given()
		    .auth().oauth2(accessToken)
		    .pathParam("USER_ID",2948)
		    .when()
		    .post("http://coop.apps.symfonycasts.com/api/{USER_ID}/chickens-feed")
		    .then()
		    .log().all();
		    
	}

}
