package by.andersenlab.quickstart.lesson10;

import by.andersenlab.quickstart.lesson10.config.SeleniumConfig;
import by.andersenlab.quickstart.lesson10.config.WebDriverWrapper;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RegistrationEmailTest {

    private static WebDriverWrapper driver;
    private static final Set<String> possibleErrors = new HashSet<>();

    @BeforeAll
    public static void setup() {
        driver = new SeleniumConfig().getDriver();
        possibleErrors.add("Необходимо заполнить «E-mail».");
        possibleErrors.add("Значение «E-mail» не является правильным email адресом.");
        possibleErrors.add("Использование одновременно русских и латинских символов недопустимо");
    }

    @BeforeEach
    public void openPage() {
        driver.open("https://diary.ru/user/registration");
    }

    @Test
    public void given_emptyEmail_when_registration_showsError() {
        driver.click(By.id("signup_btn"));
        Assertions.assertTrue(hasEmailError());
    }

    @Test
    public void given_incorrectEmail_when_registration_showsError() {
        driver.write(By.id("signupform-email"), "hoho@ho");
        driver.click(By.id("signup_btn"));
        Assertions.assertTrue(hasEmailError());
    }

    @Test
    public void given_correctEmail_when_registration_NoError() {
        driver.write(By.id("signupform-email"), "hoho@ho.ho");
        driver.click(By.id("signup_btn"));
        Assertions.assertFalse(hasEmailError());
    }

    private boolean hasEmailError() {
        driver.waitUntilElementIsClickable(By.id("signup_btn"));
        List<String> errors = driver.getTexts(By.className("help-block-error"));
        for (String error : errors) {
            if (possibleErrors.contains(error)) {
                return true;
            }
        }
        return false;
    }

    @AfterAll
    public static void shutdown() {
        driver.quit();
    }
}
