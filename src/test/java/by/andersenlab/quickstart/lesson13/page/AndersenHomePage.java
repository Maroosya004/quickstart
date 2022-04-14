package by.andersenlab.quickstart.lesson13.page;

import by.andersenlab.quickstart.lesson11.page.AbstractPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AndersenHomePage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(), 'skype')]")
    private WebElement SkypeBtn;

    @FindBy(xpath = "//a[contains(text(), 'whatsApp')]")
    private WebElement WhatsAppBtn;

    public void pressSkypeBtn() {
        clickElementWithJs(SkypeBtn);
    }

    public void pressWhatsAppBtn() {
        clickElementWithJs(WhatsAppBtn);
    }

    public void open() {
        openPage("https://andersenlab.com/");
    }
}
