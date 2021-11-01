package org.web.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStudent_5_Delete {

    String deleteEndpoint = "https://reqres.in/api/users/955";

    @Test
    public void deleteStudent() {
        Response deleteResponse = RestAssured.delete(deleteEndpoint);

        System.out.println(deleteResponse.statusCode());
        Assert.assertEquals(deleteResponse.statusCode(), 204);

    }


}
