package Pojo;

import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.response.ValidatableResponse;

import static io.restassured.RestAssured.given;

import java.util.List;

public class TestPojo {

    static final String POST_URI = "https://reqres.in/api/users";
    static final String GET_URI = "https://reqres.in/api/users";

    static PostPojoData newStudent = new PostPojoData("John", "Designer");




    @Test

    public void TestAllContent() {

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        ListOfUsersApi pojo = RestAssured.given().when().get().as(ListOfUsersApi.class);
        System.out.println(pojo.toString());

    }

    //Access data//

    @Test
    public void TestAllDataContent() {

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        ListOfUsersApi pojo = RestAssured.given().when().get().as(ListOfUsersApi.class);
        System.out.println(pojo.getData());

    }

    @Test
    public void TestAllSupportData() {

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        ListOfUsersApi pojo = RestAssured.given().when().get().as(ListOfUsersApi.class);
        System.out.println(pojo.getSupport());

    }

    @Test
    public void TestGetTotal_pages() {

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        ListOfUsersApi pojo = RestAssured.given().when().get().as(ListOfUsersApi.class);
        System.out.println(pojo.getTotal_pages());
    }

    @Test
    public void TestGetList() {

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        ListOfUsersApi pojo = RestAssured.given().when().get().as(ListOfUsersApi.class);
        System.out.println("List" + pojo.getData());
        List<DataPojo> list = pojo.getData();
    }

    @Test
    public void TestGetSpecificName() {

        RestAssured.baseURI = "https://reqres.in/api/users?page=2";
        ListOfUsersApi pojo = RestAssured.given().when().get().as(ListOfUsersApi.class);
        System.out.println("List" + pojo.getData());
        List<DataPojo> list = pojo.getData();
    }

    @Test
    public void serializeTest() {
        post();
    }


    @Test

    public void PostRequestCreateStudent() {
        PostInfo postInfo = post().extract().body().as(PostInfo.class);


         PostPojoData postStudent = given()
                .get(POST_URI + PostInfo.getJob())
                .then()
                .extract().body().as(PostPojoData.class);

        Assert.assertEquals(postStudent.toString(), PostInfo.getName().toString());


    }

    private static ValidatableResponse post() {
        return given()
                .contentType("application/json")
                .accept("application/json")
                .body(PostPojoData.class)
                .post(POST_URI)
                .then()
                .statusCode(200);
    }

}