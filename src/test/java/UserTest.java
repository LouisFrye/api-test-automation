import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;
public class UserTest {
    private User user;
    @BeforeEach
    void setUp() {
        user = new User("admin", "1234");
    }
    @Test
    void loginShouldReturnFalseForWrongPassword() {
        User user = new User("admin", "1234");
        assertFalse(user.login("admin", "wrong"));
    }

    @Test
    void loginShouldReturnFalseForNullInput() {
        User user = new User("admin", "1234");
        assertFalse(user.login(null, "1234"));
    }

    @Test
    void loginShouldIgnoreLeadingAndTrailingWhitespace() {
        User user = new User("admin", "1234");
        assertTrue(user.login(" admin ", " 1234 "));
    }
}