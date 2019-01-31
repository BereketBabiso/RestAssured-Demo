package com.berry.restassureddemo.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;

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

}
