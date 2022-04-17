package by.andersenlab.quickstart.lesson10;

import by.andersenlab.quickstart.lesson11.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class RegistrationPage extends AbstractPage {

    @FindBy(id = "signup_btn")
    private WebElement signUpBtn;

    @FindBy(id = "signupform-email")
    private WebElement emailField;

    @FindBy(css = ".has-error > .help-block-error")
    private List<WebElement> errors;

    public void pressSignUpBtn() {
        clickElementWithJs(signUpBtn);
    }

    public void fillEmailField(String email) {
        setValue(emailField, email);
    }

    public List<String> getErrors() {
        waitUntilElementToBeClickable(signUpBtn);
        List<String> stringErrors = new ArrayList<>();
        for (WebElement error : errors) {
            stringErrors.add(getElementText(error));
        }
        return stringErrors;
    }

    public void open() {
        openPage("https://diary.ru/user/registration");
    }
}

