package by.andersenlab.quickstart.lesson11.form;

import by.andersenlab.quickstart.lesson11.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCBirthDateForm extends AbstractPage {

    @FindBy(css = "#submit-button")
    private WebElement continueBtn;

    @FindBy(css = "#day-input")
    private WebElement dayField;

    @FindBy(css = "#month-input")
    private WebElement monthField;

    @FindBy(css = "#year-input")
    private WebElement yearField;

    public void fillBirthDayForm(int birthDay) {
        setValue(dayField, String.valueOf(birthDay));
    }

    public void fillBirthMonthForm(int birthMonth) {
        setValue(monthField, String.valueOf(birthMonth));
    }

    public void fillBirthYearForm(int birthYear) {
        setValue(yearField, String.valueOf(birthYear));
    }

    public void pressContinueBtn() {
        clickElementWithJs(continueBtn);
    }
}
