package by.andersenlab.quickstart.lesson10.config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class WebDriverWrapper {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public WebDriverWrapper(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void open(String url) {
        driver.get(url);
    }

    public void quit() {
        driver.quit();
    }

    public void waitUntilElementIsClickable(By by) {
        wait.until(ExpectedConditions.elementToBeClickable(by));
    }

    public void click(By by) {
        waitUntilElementIsClickable(by);
        driver.findElement(by).click();
    }

    public void write(By by, String text) {
        waitUntilElementIsClickable(by);
        driver.findElement(by).sendKeys(text);
    }

    public List<String> getTexts(By by) {
        List<WebElement> elements = driver.findElements(by);
        List<String> strings = new ArrayList<>();
        for (WebElement element : elements) {
            strings.add(element.getText());
        }
        return strings;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public WebDriver getDriver() {
        return driver;
    }
}
