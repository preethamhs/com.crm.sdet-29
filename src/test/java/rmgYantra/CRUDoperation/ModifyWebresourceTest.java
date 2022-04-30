package rmgYantra.CRUDoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

public class ModifyWebresourceTest {
	
	@Test
	public void modifyWebresourceTest() {
		JSONObject jobj=new JSONObject();
		jobj.put("createdBy","gaja");
		jobj.put("projectName","abc");
		jobj.put("status","Completed");
		jobj.put("teamSize",123);
		
		RequestSpecification reqsep = RestAssured.given();
		reqsep.body(jobj);
		reqsep.contentType("application/json");
		Response response = reqsep.put("http://localhost:8084/projects/TY_PROJ_1602");
		ValidatableResponse validate = response.then();
		
		validate.assertThat().statusCode(200);
		validate.assertThat().contentType(ContentType.JSON);
		
		validate.log().all();
		
		
	}

}
