package org.web.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetRequestWithPath {

    String path = "/api/users?page";
    String baseUrl = "https://reqres.in/";

    @BeforeMethod
    public void preCondition() {
        RestAssured.baseURI = baseUrl;
        RestAssured.basePath = path;

    }


    @Test
    public void getRequest() {


        Response getResponse = RestAssured.get();
        System.out.println(getResponse.getStatusCode());
        System.out.println(getResponse.asPrettyString());

    }

}
