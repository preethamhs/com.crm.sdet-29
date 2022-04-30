package practice;

import org.testng.annotations.Test;

import com.rmgYantra.pojoclasses.PojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.util.LinkedHashSet;
import java.util.Random;

public class CrudOperation {
	
	@Test
	public void post() {
		
		int num = new Random().nextInt(100);
		
		PojoClass obj=new PojoClass("preethu","DP"+num, "On going",10);
		Response response = given()
		    .contentType(ContentType.JSON)
		    .body(obj)
		    .post("http://localhost:8084/addProject");
		String projectId =response.jsonPath().get("projectId");
		System.out.println(projectId);
		
		when()
		    .get("http://localhost:8084/projects/"+projectId)
		.then().log().all();
		
		Response response1 = when()
		   .get("http://localhost:8084/projects");
		
	    String allproj = response1.jsonPath().get("projectId");
	    
	    LinkedHashSet<String> set=new LinkedHashSet<String>();
	    set.add(allproj);
	    for(String pro: set) {
	    	System.out.println(pro);
	    }
		System.out.println(allproj);
		response1.then()
		   .log().all();
		
		
	}

}
