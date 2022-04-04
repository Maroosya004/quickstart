package by.andersenlab.quickstart.lesson10.config;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SeleniumConfig {

    private final WebDriverWrapper driver;

    public SeleniumConfig() {
        WebDriverManager.chromedriver().setup();
        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(5));
        driver = new WebDriverWrapper(webDriver, wait);
    }

    public WebDriverWrapper getDriver() {
        return driver;
    }
}
