package com.qa.restassured.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest1 {

	@Test
	public void loginTest() {

		RestAssured.baseURI = "http://64.227.160.186:8080";
		RequestSpecification x = RestAssured.given();
		RequestSpecification y = x.header("Content-Type", "application/json");
		RequestSpecification z = y.body("{\"username\": \"treasa01\",\"password\": \"Restassured@123\"}");
		Response response = z.post("/api/auth/login");
		
		System.out.println(response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		// https://swift.techwithjatin.com/login

		// above can be modified and written as single line using chaining of methods

		//RequestSpecification z = RestAssured.given().header("Content-Type", "application/json")
//				.body("{\"username\": \"uday1234\",\"password\": \"uday1234\"}");

	}

}
