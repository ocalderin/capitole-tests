package com.capitole.capitoletests.frameworkauto.api;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class BaseApi {
    private static final String AUTHORIZATION_HEADER = "Authorization";
    private static RequestSpecification requestSpecification;

    public static void setBaseUri(final String baseUri, final String authToken) {
        RestAssured.baseURI = baseUri;
        requestSpecification = new RequestSpecBuilder().setBaseUri(baseUri).setAccept(ContentType.JSON)
                .setContentType(ContentType.JSON).addHeader(AUTHORIZATION_HEADER, String.format("Bearer %s", authToken))
                .addFilter(new RequestLoggingFilter()).addFilter(new ResponseLoggingFilter()).build();
    }

    public static void resetBaseUri() {
        RestAssured.baseURI = null;
        requestSpecification = null;
    }

    public static Response doGet(final String path) {
        return given().spec(requestSpecification).get(path).andReturn();
    }

    public static Response doGet(final String path, final Map<String, String> params) {
        return given().spec(requestSpecification).params(params).get(path).andReturn();
    }

    public static Response doPost(final String path, final Object body, final Object... pathParams) {
        return given().spec(requestSpecification).body(body).post(path, pathParams);
    }
}
