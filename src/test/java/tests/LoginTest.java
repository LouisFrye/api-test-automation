package tests;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginTest {

    @Test
    void validLoginShouldShowSuccessMessage() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
            assertTrue(flash.getText().toLowerCase().contains("you logged into a secure area"));

        } finally {
            driver.quit();
        }
    }

    @Test
    void invalidPasswordShouldShowErrorMessage() {

        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            driver.get("https://the-internet.herokuapp.com/login");

            driver.findElement(By.id("username")).sendKeys("tomsmith");
            driver.findElement(By.id("password")).sendKeys("wrongPassword");
            driver.findElement(By.cssSelector("button[type='submit']")).click();

            WebElement flash = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("flash")));
            assertTrue(flash.getText().toLowerCase().contains("your password is invalid"));

        } finally {
            driver.quit();
        }
    }
}