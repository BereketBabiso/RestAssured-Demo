package com.berry.restassureddemo.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.nio.file.Files;

import org.hamcrest.Matchers;
import org.json.JSONObject;

@RunWith(MockitoJUnitRunner.Silent.class)
public class RestAssuredControllerTest {
	
	
	@Test
	public void test() {
		ValidatableResponse res = given().
		when().
		get("http://localhost:8080/api/test").then();
		System.out.println(res.extract().body().asString());
		res.body(Matchers.containsString("he"));
	}
	
	@Test
	public void formulaOne() {
	  ValidatableResponse res =
	  given().
	  when().
	    get("http://localhost:8080/api/f1/circuits").
	  then().
	    assertThat().
	    statusCode(200).
	  and().
	    contentType(ContentType.JSON);
//	  and().
//	    assertThat().
//	    body("MRData.RaceTable.Races.Circuit.circuitId", greaterThan(1));
	  System.out.println(res.extract().body().toString());

	}
	
	@Test
	public void test2() {
	  
	  given().
	  when().
	    get("http://localhost:8080/api/test2").
	  then().
	    assertThat().
	    body("status",equalTo("SUCCESS")).
	    body("httpStatus", equalTo("200"));	  
	  
	}
	
	@Test
	public void test3() {
	  given().
	    pathParam("appId","1001").
	    param("code", "102").
	  when().
	    get("http://localhost:8080/api/test3/{appId}"). 
	  then(). 
	    assertThat(). 
	    body("status", equalTo("FAILURE")). 
	    body("httpStatus", equalTo("417"));
	}
	
	@Test
	public void test4() {
	  String fileName = "employee.txt";
	    ClassLoader classLoader = this.getClass().getClassLoader();
	    
	    try {

	    File file = new File(classLoader.getResource(fileName).getFile());
	     
	    //File is found
	    System.out.println("File Found : " + file.exists());
	     
	    //Read File Content
	    String content = new String(Files.readAllBytes(file.toPath()));
	    System.out.println(content);
	    JSONObject jsonObject = new JSONObject(content);
	    } catch(Exception ex) {
	      Assert.fail();
	    }
	    
	    given().
	      when().
	        get("http://localhost:8080/api/test2").
	      then().
	        assertThat().
	        body("status",equalTo("SUCCESS")).
	        body("httpStatus", equalTo("200")); 
	    
	}
	
	@Test
	public void test5() {
	  String fileName = "employee.txt";
      ClassLoader classLoader = this.getClass().getClassLoader();
      String content = "";
      try {

      File file = new File(classLoader.getResource(fileName).getFile());
       
      //File is found
      System.out.println("File Found : " + file.exists());
       
      //Read File Content
      content = new String(Files.readAllBytes(file.toPath()));
      System.out.println(content);
      JSONObject jsonObject = new JSONObject(content);
      } catch(Exception ex) {
        Assert.fail();
      }
	  given().body(content).with().contentType("application/json").
	  then().
	  expect().
	  body("status", equalTo(HttpStatus.CREATED.name())).
	  when().post("http://localhost:8080/api/employee");
	}

}
