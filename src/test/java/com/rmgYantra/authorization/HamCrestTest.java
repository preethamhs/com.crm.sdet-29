package com.rmgYantra.authorization;

import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;

public class HamCrestTest {

	@Test
	public void validation() {
		when()
		    .get("http://localhost:8084/projects")
		.then()
		     .assertThat().statusCode(200)
		     .assertThat().body("[0].projectName",Matchers.equalTo("preethu"))
		     .assertThat().time(Matchers.lessThan(600L));
		
		    
	}
			
}
