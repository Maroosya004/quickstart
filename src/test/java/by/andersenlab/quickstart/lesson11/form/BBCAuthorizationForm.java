package by.andersenlab.quickstart.lesson11.form;

import by.andersenlab.quickstart.lesson11.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCAuthorizationForm extends AbstractPage {

    @FindBy(css = "input[type='email']")
    private WebElement loginField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "button[type='submit']")
    private WebElement enterBtn;

    @FindBy(xpath = "//a[@data-bbc-result='/register']")
    private WebElement registrationBtn;

    public void fillLoginField(String login) {
        setValue(loginField, login);
    }

    public void fillPasswordField(String password) {
        setValue(passwordField, password);
    }

    public void pressEnterBtn() {
        clickElement(enterBtn);
    }

    public void pressRegistrationBtn() {
        clickElement(registrationBtn);
    }
}


