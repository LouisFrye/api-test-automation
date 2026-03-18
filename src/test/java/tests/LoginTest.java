package tests;

import baseui.BaseUiTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import pages.LoginPage;

public class LoginTest extends BaseUiTest {

    @Test
    public void validLoginShouldShowSuccessMessage() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.open();
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("SuperSecretPassword!");
        loginPage.clickLogin();

        String message = loginPage.getFlashMessageText();
        Assertions.assertTrue(message.contains("You logged into a secure area!"));
    }

    @Test
    public void invalidPasswordShouldShowErrorMessage() {
        LoginPage loginPage = new LoginPage(getDriver());

        loginPage.open();
        loginPage.enterUsername("tomsmith");
        loginPage.enterPassword("wrongpassword");
        loginPage.clickLogin();

        String message = loginPage.getFlashMessageText();
        Assertions.assertTrue(message.contains("Your password is invalid!"));
    }
}