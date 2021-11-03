import io.restassured.http.ContentType;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class TestSchema {


    @Test
    void shouldReturnStatus() {

        given()
                .baseUri("https://reqres.in")
                .when()
                .get("/api/users?page=2")
                .then()
                .assertThat()
                .statusCode(200)

                .contentType(ContentType.JSON);

    }


    @Test
    void shouldCheckCurrency() {

        given()
                .baseUri("https://reqres.in")
                .when()
                .get("/api/users?page=2")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("page", greaterThanOrEqualTo(0));


    }

    @Test
    void shouldReturnStatus_2() {

        given().
                contentType(ContentType.JSON).

                when().
                get("https://reqres.in/api/users?page=2").
                then().

                assertThat().body(matchesJsonSchemaInClasspath("schema.json"));
    }
}