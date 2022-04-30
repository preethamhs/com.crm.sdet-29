package com.rmgYantra.authorization;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class PreemitiveAndDigestiveTest {
	
	@Test
	public void preemitive() {
		given()
		   .auth().preemptive().basic("rmgyantra","rmgy@9999")
		.when()
		   .get("http://localhost:8084/login")
		.then().log().all();
		
	}
	@Test
	public void digestive() {
		given()
		   .auth().digest("rmgyantra","rmgy@9999")
		.when()
		   .get("http://localhost:8084/login")
		.then().log().all();
		
	}

}
