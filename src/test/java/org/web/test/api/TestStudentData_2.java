package org.web.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestStudentData_2 {
    String getStudentEndpoint = "https://reqres.in/api/users?page=2";

    @Test
    public void validateStudentData() {
        Response response = RestAssured.get(getStudentEndpoint);
        System.out.println(response.getStatusCode());

        //assertion on status code//
        Assert.assertEquals(response.getStatusCode(), 200);

        System.out.println(response.getHeader("Server"));
        Assert.assertEquals(response.getHeader("Server"), "cloudflare");

        //fetch body content//
        System.out.println(response.asPrettyString());
        Assert.assertTrue(response.asPrettyString().contains("Michael"));

        //fetch body content using json path//

        Assert.assertEquals(response.jsonPath().getString("data.first_name"), "[Michael, Lindsay, Tobias, Byron, George, Rachel]");
        Assert.assertEquals(response.jsonPath().getString("data.id"), "[7, 8, 9, 10, 11, 12]");


    }
}
