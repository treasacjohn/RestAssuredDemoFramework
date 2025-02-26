package com.qa.restassured.base;

import com.qa.restassured.models.request.LoginRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService {

	private static final String BASE_PATH = "/api/auth/";

	public Response login(LoginRequest payload) {
		return postRequest(payload, BASE_PATH + "login");

	}

}
