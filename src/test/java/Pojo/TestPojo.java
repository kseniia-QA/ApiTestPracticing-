package Pojo;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

import java.util.List;

public class TestPojo {

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
}