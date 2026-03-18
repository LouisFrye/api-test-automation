package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    @Step("Open login page")
    public void open() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @Step("Enter username: {username}")
    public void enterUsername(String username) {
        driver.findElement(By.id("username")).sendKeys(username);
    }

    @Step("Enter password")
    public void enterPassword(String password) {
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @Step("Click login button")
    public void clickLogin() {
        driver.findElement(By.cssSelector("button[type='submit']")).click();
    }

    public String getFlashMessageText() {
        return driver.findElement(By.id("flash")).getText();
    }
}