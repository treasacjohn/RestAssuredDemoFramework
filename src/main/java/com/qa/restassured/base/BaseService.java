package com.qa.restassured.base;

import static io.restassured.RestAssured.*;

import com.qa.restassured.filters.LoggingFilter;
import com.qa.restassured.models.request.LoginRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {

	// BaseURI
	// Creating the requests
	// Handling the responses

	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;

	static {
		RestAssured.filters(new LoggingFilter());

	}

	public BaseService() {
		requestSpecification = given().baseUri(BASE_URL);

	}

	protected Response postRequest(Object payload, String endpoint) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);

	}

}
