package by.andersenlab.quickstart.lesson11.test;

import by.andersenlab.quickstart.lesson11.DriverSingleton;
import by.andersenlab.quickstart.lesson11.form.BBCAgeCheckForm;
import by.andersenlab.quickstart.lesson11.form.BBCAuthorizationForm;
import by.andersenlab.quickstart.lesson11.form.BBCBirthDateForm;
import by.andersenlab.quickstart.lesson11.form.BBCRegistrationForm;
import by.andersenlab.quickstart.lesson11.page.BBCHomePage;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BBCPasswordTest {

    private static final HashMap<String, String> possibleErrors = new HashMap<>();

    @BeforeClass
    public static void setPossibleErrors() {
        possibleErrors.put("short password", "Извините, этот пароль слишком короткий. В нём должно быть не менее 8 символов.");
        possibleErrors.put("no letters", "Извините, этот пароль недействителен. Пожалуйста, включите одну букву.");
        possibleErrors.put("no numbers", "Извините, этот пароль недействителен. Пожалуйста, включите что-нибудь, кроме букв.");
    }

    @Test
    public void given_incorrectPassword_when_registration_showsError() {
        BBCHomePage homePage = new BBCHomePage();
        homePage.open();
        homePage.pressLoginBtn();

        BBCAuthorizationForm authorizationPage = new BBCAuthorizationForm();
        authorizationPage.pressRegistrationBtn();

        BBCAgeCheckForm ageCheckForm = new BBCAgeCheckForm();
        ageCheckForm.pressRegistrationBtn();

        BBCBirthDateForm birthDateForm = new BBCBirthDateForm();
        birthDateForm.fillBirthDayForm(24);
        birthDateForm.fillBirthMonthForm(5);
        birthDateForm.fillBirthYearForm(2000);
        birthDateForm.pressContinueBtn();

        BBCRegistrationForm registrationForm = new BBCRegistrationForm();
        registrationForm.fillEmailField("makhnetsova.m@gmail.com");
        registrationForm.fillPasswordField("123456");
        registrationForm.pressCountryBtn();
        Assert.assertEquals(possibleErrors.get("short password"), registrationForm.getPasswordError());
        registrationForm.clearPasswordField();

        registrationForm.fillPasswordField("12345678");
        registrationForm.pressCountryBtn();
        Assert.assertEquals(possibleErrors.get("no letters"), registrationForm.getPasswordError());
        registrationForm.clearPasswordField();

        registrationForm.fillPasswordField("francophone");
        registrationForm.pressCountryBtn();
        Assert.assertEquals(possibleErrors.get("no numbers"), registrationForm.getPasswordError());
        registrationForm.clearPasswordField();
    }

    @AfterClass
    public static void shutdown() {
        DriverSingleton.closeDriver();
    }
}
