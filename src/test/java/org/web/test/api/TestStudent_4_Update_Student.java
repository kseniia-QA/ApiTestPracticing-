package org.web.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStudent_4_Update_Student {

    String putEndPoint = "https://reqres.in/api/users/955";


    @Test
    public void updateNewStudent() {
        //configuration//
        RequestSpecification putRequest = RestAssured.given();
        putRequest.body("{  \"name\": \"ksui\", \"job\": \"tester\"}");
        putRequest.header("content-type", "application/json");

//Send put request//
        Response putresponse = putRequest.put(putEndPoint);
        System.out.println(putresponse.getStatusCode());
        Assert.assertEquals(putresponse.getStatusCode(), 200);
        System.out.println(putresponse.asPrettyString());

    }

}




