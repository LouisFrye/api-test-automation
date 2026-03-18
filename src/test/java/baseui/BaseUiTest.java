package baseui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestListener;

@ExtendWith(TestListener.class)
public class BaseUiTest {

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    protected WebDriver getDriver() {
        return driver.get();
    }

    public static WebDriver getDriverStatic() {
        return driver.get();
    }

    @BeforeEach
    void setUp() {
        driver.set(new ChromeDriver());
        getDriver().manage().window().maximize();
    }

    @AfterEach
    void tearDown() {
        if (getDriver() != null) {
            getDriver().quit();
            driver.remove();
        }
    }
}