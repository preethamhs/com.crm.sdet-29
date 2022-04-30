package rmgYantra.CRUDoperation;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.*;

public class UserModule {

	@Test
	public void post() {
		JSONObject jobj=new JSONObject();
		jobj.put("designation","SDET");
		jobj.put("dob","25/05/1999");
		jobj.put("email","nithesh@gmail.com");
		jobj.put("empName","nithesh");
		jobj.put("experience","15");
		jobj.put("mobileNo","9888777657");
		jobj.put("project","hdfc77");
		jobj.put("role","SDET");
		jobj.put("designation","ROLE_ADMIN");
		jobj.put("username","nith102");
		
		/*given()
	      .body(jobj)
        .contentType(ContentType.JSON)
        . when()
        .post("http://localhost:8084/employees")
        //Object actProjName = resp.jsonPath().get("projectName");
        //System.out.println(actProjName);
        given()
        .
        .then()
         .log().all();*/
		RequestSpecification respec = RestAssured.given();
		respec.body(jobj);
		respec.contentType(ContentType.JSON);
		Response response = respec.post("http://localhost:8084/employees");
		Object actProjName = response.jsonPath().get("projectName");
		System.out.println(actProjName);
	     ValidatableResponse validate = response.then();
	  
		validate.log().all();
		validate.assertThat().statusCode(201);
		validate.assertThat().contentType(ContentType.JSON);


	}

}
