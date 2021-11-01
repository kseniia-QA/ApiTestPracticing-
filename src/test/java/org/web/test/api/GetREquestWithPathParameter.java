package org.web.test.api;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class GetREquestWithPathParameter {


    String basePath = "api/users/";
    String baseUrl = "https://reqres.in/";
    RequestSpecification reqSpec;


    @BeforeMethod
    public void setConfiguration() {
        reqSpec = RestAssured.given();
        reqSpec.baseUri(baseUrl);
        reqSpec.basePath(basePath);
        reqSpec.pathParam("ID", 3);
        System.out.println(reqSpec.log().all());
    }

    @Test
    public void request() {

        Response getResponse = reqSpec.get("{ID}");
        System.out.println(getResponse.getStatusCode());
        System.out.println(getResponse.asPrettyString());
    }
}