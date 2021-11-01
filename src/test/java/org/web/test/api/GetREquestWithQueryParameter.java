package org.web.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GetREquestWithQueryParameter {

    String basePath = "api/users/";
    String baseUrl = "https://reqres.in/";
    RequestSpecification reqSpec;


    @BeforeMethod
    public void setConfiguration() {
        reqSpec = RestAssured.given();
        reqSpec.baseUri(baseUrl);
        reqSpec.basePath(basePath);
        reqSpec.queryParam("page", "4");
        reqSpec.queryParam("name", "hi");
        System.out.println(reqSpec.log().all());
    }

    @Test
    public void request() {


        Response getResponse = reqSpec.get();
        System.out.println(getResponse.getStatusCode());
        System.out.println(getResponse.asPrettyString());


    }
}








