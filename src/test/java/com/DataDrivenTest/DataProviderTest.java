package com.DataDrivenTest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.rmgYantra.pojoclasses.PojoClass;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.*;

public class DataProviderTest {
	
	@Test(dataProvider = "getdata")
	public void dataProvider(String createdBy,String projectName,String status,int teamSize) {
		PojoClass obj=new PojoClass(createdBy, projectName, status, teamSize);
		
		given()
		     .body(obj)
		     .contentType(ContentType.JSON)
		     .post("http://localhost:8084/addProject")
		.then().log().all();
	}
	
	@DataProvider
	public Object[][] getdata() {
	     Object[][] objArray = new Object[4][4];
	    
	    objArray[0][0]="preetham";
	    objArray[0][1]="Money heist";
	    objArray[0][2]="Completed";
	    objArray[0][3]=10;
	    
	    objArray[1][0]="liki";
	    objArray[1][1]="game of thrones";
	    objArray[1][2]="On going";
	    objArray[1][3]=20;
	    
	    objArray[2][0]="kishu";
	    objArray[2][1]="pubg";
	    objArray[2][2]="Completed";
	    objArray[2][3]=30;
	    
	    objArray[3][0]="devi";
	    objArray[3][1]="carrom";
	    objArray[3][2]="Completed";
	    objArray[3][3]=40;
	    return objArray;
	}

}
