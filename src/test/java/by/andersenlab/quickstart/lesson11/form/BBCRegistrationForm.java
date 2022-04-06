package by.andersenlab.quickstart.lesson11.form;

import by.andersenlab.quickstart.lesson11.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCRegistrationForm extends AbstractPage {

    @FindBy(css = "input[type='email']")
    private WebElement emailField;

    @FindBy(css = "input[type='password']")
    private WebElement passwordField;

    @FindBy(css = "#location-select")
    private WebElement countrySelectBtn;

    @FindBy(css = "option[value='by']")
    private WebElement countryBtn;

    @FindBy(css = "button[type='submit']")
    private WebElement registrationBtn;

    @FindBy(css = "div[data-bbc-title='password-error']")
    private WebElement passwordError;

    public String getPasswordError() {
        return getElementText(passwordError);
    }

    public void clearPasswordField() {
        passwordField.clear();
    }

    public void fillEmailField(String login) {
        setValue(emailField, login);
    }

    public void fillPasswordField(String password) {
        setValue(passwordField, password);
    }

    public void pressCountryBtn() {
        clickElement(countryBtn);
    }
}
