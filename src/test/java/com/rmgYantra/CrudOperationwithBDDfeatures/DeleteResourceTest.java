package com.rmgYantra.CrudOperationwithBDDfeatures;

import org.testng.annotations.Test;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DeleteResourceTest {
	
	@Test
	public void deleteResourceTest() {
		when()
		     .delete("http://localhost:8084/projects/TY_PROJ_1405")
		.then()
		      .assertThat().statusCode(204)
		      .assertThat().contentType(ContentType.JSON);
	}

}
