package rmgYantra.CRUDoperation;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

public class GetAllWebResourceTest {
   @Test
   public void getAllWebResource() {
	   Response response = RestAssured.get("http://localhost:8084/projects");
	   
	  // System.out.println("content type"+response.getContentType());
	  // System.out.println("status code"+response.getStatusCode());
	  // System.out.println("header"+response.getHeader("vary"));
	  // System.out.println("response time"+response.getTime());
	   //System.out.println("body-"+response.getBody());
	  // System.out.println("status line"+response.getStatusLine());
	  // System.out.println("cookies"+response.getCookies());
	  //System.out.println("headers"+response.getHeaders());
	  
	   
	  response.prettyPrint();
	   //System.out.println(response.asPrettyString());
	   //response.prettyPeek();
	  /*System.out.println(response.print());
	  
	   ValidatableResponse validate = response.then();
	   System.out.println("=========================");
	   validate.log().all();*/
	   
   }
}
