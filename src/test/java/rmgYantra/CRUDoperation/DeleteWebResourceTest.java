package rmgYantra.CRUDoperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class DeleteWebResourceTest {
	
	@Test
	public void deleteWebResource() {
		Response response = RestAssured.delete("http://localhost:8084/projects/TY_PROJ_1407");
		ValidatableResponse validate = response.then();
		validate.log().all();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(204);
		
		
	}

}
