package by.andersenlab.quickstart.lesson11.form;

import by.andersenlab.quickstart.lesson11.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCAgeCheckForm extends AbstractPage {

    @FindBy(xpath = "//a[@data-bbc-result='/register/details/age']")
    private WebElement ageBtn;

    public void pressRegistrationBtn() {
        clickElementWithJs(ageBtn);
    }
}
