package by.andersenlab.quickstart.lesson11.page;

import by.andersenlab.quickstart.lesson11.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BBCHomePage extends AbstractPage {

    @FindBy(css = "#idcta-link")
    private WebElement loginBtn;

    public void pressLoginBtn() {
        clickElement(loginBtn);
    }

    public void open() {
        openPage("https://www.bbc.com/");
    }
}
