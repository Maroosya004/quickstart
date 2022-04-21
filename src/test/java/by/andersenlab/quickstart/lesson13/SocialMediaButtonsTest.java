package by.andersenlab.quickstart.lesson13;

import by.andersenlab.quickstart.lesson11.DriverSingleton;
import by.andersenlab.quickstart.lesson13.page.AndersenHomePage;
import by.andersenlab.quickstart.lesson13.page.JoinSkypePage;
import by.andersenlab.quickstart.lesson13.page.JoinWhatsAppPage;
import by.andersenlab.quickstart.lesson15.BrowserLogs;
import org.junit.jupiter.api.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SocialMediaButtonsTest {

    private static final Logger logger = LoggerFactory.getLogger(SocialMediaButtonsTest.class);

    private final AndersenHomePage andersenHomePage = new AndersenHomePage();

    @BeforeEach
    public void open() {
        andersenHomePage.open();
    }

    @Test
    public void transitionToSkypePage_when_Btn_isClickable() {
        andersenHomePage.pressSkypeBtn();
        andersenHomePage.switchToNextTab();
        JoinSkypePage joinSkypePage = new JoinSkypePage();
        boolean resultUrl = joinSkypePage.getPageUrl().startsWith("https://join.skype.com");
        Assertions.assertTrue(resultUrl);
    }

    @Test
    public void transitionToWhatsAppPage_when_Btn_isClickable() {
        andersenHomePage.pressWhatsAppBtn();
        andersenHomePage.switchToNextTab();
        JoinWhatsAppPage joinWhatsAppPage = new JoinWhatsAppPage();
        boolean resultUrl = joinWhatsAppPage.getPageUrl().startsWith("https://chat.whatsapp.com");
        Assertions.assertTrue(resultUrl);
    }

    @AfterEach
    public void tearDown() {
        BrowserLogs.printLogs(logger);
        DriverSingleton.resetTabs();
    }

    @AfterAll
    public static void shutdown() {
        DriverSingleton.closeDriver();
    }
}
