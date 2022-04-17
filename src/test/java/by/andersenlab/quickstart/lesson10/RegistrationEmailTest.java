package by.andersenlab.quickstart.lesson10;

import by.andersenlab.quickstart.lesson11.DriverSingleton;
import org.junit.jupiter.api.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RegistrationEmailTest {

    private static final Set<String> possibleErrors = new HashSet<>();
    private RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    public static void setup() {
        possibleErrors.add("Необходимо заполнить «E-mail».");
        possibleErrors.add("Значение «E-mail» не является правильным email адресом.");
        possibleErrors.add("Использование одновременно русских и латинских символов недопустимо");
    }

    @BeforeEach
    public void openPage() {
        registrationPage.open();
    }

    @Test
    public void given_emptyEmail_when_registration_showsError() {
        registrationPage.pressSignUpBtn();
        registrationPage = new RegistrationPage();
        Assertions.assertTrue(hasEmailError());
    }

    @Test
    public void given_incorrectEmail_when_registration_showsError() {
        registrationPage.fillEmailField("hoho@ho");
        registrationPage.pressSignUpBtn();
        Assertions.assertTrue(hasEmailError());
    }

    @Test
    public void given_correctEmail_when_registration_NoError() {
        registrationPage.fillEmailField("hoho@ho.ho");
        registrationPage.pressSignUpBtn();
        Assertions.assertFalse(hasEmailError());
    }

    private boolean hasEmailError() {
        List<String> errors = registrationPage.getErrors();
        for (String error : errors) {
            if (possibleErrors.contains(error)) {
                return true;
            }
        }
        return false;
    }

    @AfterAll
    public static void shutdown() {
        DriverSingleton.closeDriver();
    }
}
