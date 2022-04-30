package rmgYantra.CRUDoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class PartialUpdationTest {
	@Test
	public void partialUpdation() {
		JSONObject jobj=new JSONObject();
		jobj.put("name","gaja");
		jobj.put("job","test engineer");
		
		RequestSpecification reqspe = RestAssured.given();
		reqspe.body(jobj);
		reqspe.contentType(ContentType.JSON);
		Response response = reqspe.patch("https://reqres.in/api/users/2");
		ValidatableResponse validate = response.then();
		validate.assertThat().contentType(ContentType.JSON);
		validate.assertThat().statusCode(200);
		validate.log().all();
		
	}

}
