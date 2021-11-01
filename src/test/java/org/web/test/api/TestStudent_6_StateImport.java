package org.web.test.api;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.get;

public class TestStudent_6_StateImport {


    String getStudentEndpoint = "https://reqres.in/api/users?page=2";

    @Test
    public void validateStudentData() {

        Response response = get(getStudentEndpoint);
        System.out.println(response.getStatusCode());
        System.out.println("All headers value" + response.getHeaders());

//fetch specific header value/
        System.out.println(response.getHeader("Age"));

//fetch body data//

        System.out.println(response.asString());

        System.out.println(response.asPrettyString());

    }

}