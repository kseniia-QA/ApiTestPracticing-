package org.web.test.api;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

public class End_to_end_testcase {


    String applicationBaseUrl = "https://reqres.in/api/users";

    String name = "Helen";
    String job = "QA";

    String postRequestBody = "{  \"name\": \"someName\", \"job\": \"someJob\" }";

    @Test
    public void addNewStudent() {
        //post new student to an application//

        RequestSpecification postRequestSpecification = RestAssured.given();
        postRequestSpecification.body(postRequestBody.replace("someName", name).replace("someJob", job));
        postRequestSpecification.header("content-type", "application/json");

        Response postResponse = postRequestSpecification.post("https://reqres.in/api/users");
        System.out.println(postResponse.asPrettyString());
        String name = postResponse.jsonPath().getString("name");

        Response getResponse = RestAssured.get("https://reqres.in/api/users?page");
        Assert.assertEquals(getResponse.getStatusCode(), 200);
//       Assert.assertEquals(getResponse.jsonPath().getString("data.name"), "Helen");


        //Update job//
        RequestSpecification putRequestSpecification = RestAssured.given();
        putRequestSpecification.body(postRequestBody.replace("someName", name).replace("someJob", job));
        putRequestSpecification.header("content-type", "application/json");
        Response putResponse = putRequestSpecification.put("https://reqres.in/api/users/2");
        Assert.assertEquals(putResponse.getStatusCode(), 200);

//Delete the student//

        Response deleteResponse = RestAssured.delete("https://reqres.in/api/users/2");
        Assert.assertEquals(deleteResponse.getStatusCode(), 204);


    }


}
