package org.web.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStudent_3_Add_Student {

    String postEndPoint = "https://reqres.in/api/users";


    @Test
    public void addNewStudent() {
        //prerequisite//
        RequestSpecification postRequest = RestAssured.given();
        postRequest.body("{  \"name\": \"gilly\", \"job\": \"assistant\"}");
        postRequest.header("content-type", "application/json");


        Response postresponse = postRequest.post(postEndPoint);
        System.out.println(postresponse.statusCode());
        Assert.assertEquals(postresponse.statusCode(), 201);
        System.out.println(postresponse.asPrettyString());

    }

}




