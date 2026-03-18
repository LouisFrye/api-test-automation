package tests;

import base.BaseTest;
import data.TestData;
import io.qameta.allure.junit5.AllureJunit5;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

@ExtendWith(AllureJunit5.class)
@Tag("api")
public class UserApiTest extends BaseTest {

    @Test
    @Tag("smoke")
    void getUsersShouldReturn200() {
        given()
                .when()
                .get("/users")
                .then()
                .statusCode(200)
                .body("$", not(empty()));
    }

    @Test
    @Tag("regression")
    void getUser1ShouldReturnCorrectUser() {
        given()
                .when()
                .get("/users/" + TestData.VALID_USER_ID)
                .then()
                .statusCode(200)
                .body("id", equalTo(TestData.VALID_USER_ID))
                .body("name", not(emptyString()))
                .body("email", containsString("@"));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @Tag("regression")
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
    @Tag("regression")
    void getUserShouldReturnExpectedStatus(int userId, int expectedStatus) {
        given()
                .when()
                .get("/users/" + userId)
                .then()
                .statusCode(expectedStatus);
    }
}