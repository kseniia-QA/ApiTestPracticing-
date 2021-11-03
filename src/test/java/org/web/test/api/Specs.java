package org.web.test.api;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static java.lang.System.getProperty;
import static org.hamcrest.Matchers.lessThanOrEqualTo;


class Specs{
    static final String BASE_URI = getProperty("baseUri");
    static final Long responseTime = Long.valueOf(getProperty("responseTime"));

    public static RequestSpecification requestSpec = new RequestSpecBuilder()
            .addFilter(new AllureRestAssured())
            .setBaseUri(BASE_URI)
            .setContentType(ContentType.JSON)
            .setAccept("application/json")
            .addHeader("Cookie", "token=" + getProperty("token"))
            .build();

    public static ResponseSpecification responseSpec(int statusCode) {
        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectResponseTime(lessThanOrEqualTo(responseTime))
                .build();
    }

}
