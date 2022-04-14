package by.andersenlab.quickstart.lesson11.test;

import by.andersenlab.quickstart.lesson11.DriverSingleton;
import by.andersenlab.quickstart.lesson11.form.BBCAuthorizationForm;
import by.andersenlab.quickstart.lesson11.page.AccountHomePage;
import by.andersenlab.quickstart.lesson11.page.BBCHomePage;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AuthorizationTest {

    @Test
    public void given_correctCredentials_when_authorization_is_successful() {
        BBCHomePage homePage = new BBCHomePage();
        homePage.open();
        homePage.pressLoginBtn();

        BBCAuthorizationForm authorizationPage = new BBCAuthorizationForm();
        authorizationPage.fillLoginField("makhnetsova.m@gmail.com");
        authorizationPage.fillPasswordField("maroosya004");
        authorizationPage.pressEnterBtn();

        AccountHomePage accountHomePage = new AccountHomePage();
        Assertions.assertEquals("https://www.bbc.com/", accountHomePage.getPageUrl());
    }

    @AfterAll
    public static void shutdown() {
        DriverSingleton.closeDriver();
    }
}

