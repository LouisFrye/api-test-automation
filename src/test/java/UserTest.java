import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {

    private User user;

    @BeforeEach
    void setUp() {
        user = new User("admin", "1234");
    }

    @Test
    void loginShouldReturnFalseForWrongPassword() {
        assertFalse(user.login("admin", "wrong"));
    }

    @Test
    void loginShouldReturnFalseForNullInput() {
        assertFalse(user.login(null, "1234"));
    }

    @Test
    void loginShouldIgnoreLeadingAndTrailingWhitespace() {
        assertTrue(user.login(" admin ", " 1234 "));
    }
}