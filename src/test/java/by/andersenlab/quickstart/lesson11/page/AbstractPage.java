package by.andersenlab.quickstart.lesson11.page;

import by.andersenlab.quickstart.lesson11.DriverSingleton;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AbstractPage {

    private final WebDriver driver = DriverSingleton.getDriver();
    private final WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

    protected AbstractPage() {
        PageFactory.initElements(driver, this);
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }

    public void switchToNextTab() {
        List<String> tabs = new ArrayList<>(DriverSingleton.getDriver().getWindowHandles());
        String currentTab = driver.getWindowHandle();
        int currentTabIndex = tabs.indexOf(currentTab);

        int nextTabIndex = currentTabIndex + 1;
        String nextTab;
        if (nextTabIndex >= tabs.size()) {
            nextTab = tabs.get(0);
        } else {
            nextTab = tabs.get(nextTabIndex);
        }
        driver.switchTo().window(nextTab);
    }

    protected void waitUntilElementToBeClickable(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    protected void waitUntilElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    protected void openPage(String pageUrl) {
        driver.get(pageUrl);
    }

    protected void setValue(WebElement element, String text) {
        element.sendKeys(text);
    }

    protected void clickElement(WebElement element) {
        waitUntilElementToBeClickable(element);
        element.click();
    }

    protected void clickElementWithJs(WebElement element) {
        JavascriptExecutor executor = (JavascriptExecutor) driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected String getElementText(WebElement element) {
        waitUntilElementIsVisible(element);
        return element.getText();
    }
}
