package org.web.test.api;

import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class TestStudent_7_BDD {


    String postEndPoint = "https://reqres.in/api/users";


    @Test
    public void addNewStudent() {
        given()
                .contentType(ContentType.JSON)
                .body("{  \"name\": \"gilly\", \"job\": \"assistant\"}")

                .when()
                .post(postEndPoint)
                .then()

                .statusCode(201);


    }

}


