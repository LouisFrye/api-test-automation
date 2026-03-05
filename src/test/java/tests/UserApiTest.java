package tests;

import base.BaseTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import data.TestData;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class UserApiTest extends BaseTest {

    @Test
    void getUsersShouldReturn200() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("$", not(empty()));
    }

    @Test
    void getUser1ShouldReturnCorrectUser() {
        given()
                .when()
                .get("/users/1")
                .then()
                .statusCode(200)
                .body("id", equalTo(1))
                .body("name", not(emptyString()))
                .body("email", containsString("@"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    void getUserShouldReturn200ForValidIds(int userId) {
        given()
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(200)
                .body("id", equalTo(userId));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 200",
            "2, 200",
            "9999, 404"
    })
    void getUserShouldReturnExpectedStatus(int userId, int expectedStatus) {
        given()
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(expectedStatus);
    }
}