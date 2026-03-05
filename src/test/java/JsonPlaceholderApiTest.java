import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class JsonPlaceholderApiTest {

    @BeforeAll
    static void setup() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
    }

    @Test
    void getUsersShouldReturn200AndNonEmptyArray() {
        given()
        .when()
            .get("/users")
        .then()
            .statusCode(200)
            .contentType(containsString("application/json"))
            .body("$", is(not(empty())));
    }

    @Test
    void getUser1ShouldReturn200AndId1() {
        given()
        .when()
            .get("/users/1")
        .then()
            .statusCode(200)
            .body("id", equalTo(1));
    }

    @Test
    void getMissingUserShouldReturn404() {
        given()
        .when()
            .get("/users/9999")
        .then()
            .statusCode(404);
    }
}
