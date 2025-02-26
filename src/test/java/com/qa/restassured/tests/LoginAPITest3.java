package com.qa.restassured.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.qa.restassured.base.AuthService;
import com.qa.restassured.models.request.LoginRequest;
import com.qa.restassured.models.response.LoginResponse;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Listeners(com.qa.restassured.listeners.TestListener.class)
public class LoginAPITest3 {

	@Test
	public void loginTest() {
		
		LoginRequest loginRequest = new LoginRequest("treasa01", "Restassured@123");
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		LoginResponse loginResponse = response.as(LoginResponse.class);
		
		System.out.println(response.asPrettyString());
		System.out.println(loginResponse.getToken());
		System.out.println(loginResponse.getEmail());
		System.out.println(loginResponse.getId());
		System.out.println(loginResponse.getUsername());
		System.out.println(loginResponse.getRoles());
		
		Assert.assertTrue(loginResponse.getToken() != null);
		Assert.assertEquals(loginResponse.getEmail(), "treasa@test.com");
		Assert.assertEquals(loginResponse.getId(), 224);
		Assert.assertEquals(loginResponse.getUsername(), "treasa01");
		

	}

}
