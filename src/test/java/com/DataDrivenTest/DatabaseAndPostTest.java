package com.DataDrivenTest;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.mysql.cj.jdbc.Driver;
import com.rmgYantra.pojoclasses.PojoClass;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

public class DatabaseAndPostTest {
	
	@Test
	public void databaseTesting() throws SQLException {
		int random = new Random().nextInt(100);
		PojoClass obj=new PojoClass("DP","game"+random, "completed",20);
		Response response =given()
		  .body(obj)
		  .contentType(ContentType.JSON)
		.when()
		  .post("http://localhost:8084/addProject");
		String projectName = response.jsonPath().get("projectName");
		String projectId = response.jsonPath().get("projectId");
		response.then().log().all();
		
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projects","root","root");
		Statement stat = conn.createStatement();
		//String query = "select * from project where projectId="+projectId+"";
		
		ResultSet resultset = stat.executeQuery("select * from project");
		boolean flag=false;
		while(resultset.next()) {
			String actProjectName = resultset.getString(4);
			if(actProjectName.equals(projectName)) {
				flag=true;
				Assert.assertEquals(actProjectName, projectName);
				break;
			}
			/*else {
				resultset.next();
			}*/
		}
		Assert.assertTrue(flag);
		conn.close();
	}
}
