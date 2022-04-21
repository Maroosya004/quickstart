package by.andersenlab.quickstart.lesson15;

import by.andersenlab.quickstart.lesson11.DriverSingleton;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.slf4j.Logger;
import java.util.Date;
import java.util.List;

public class BrowserLogs {

    public static void printLogs(Logger logger) {
        LogEntries browserLogs = DriverSingleton.getDriver().manage().logs().get(LogType.BROWSER);
        List<LogEntry> allLogRows = browserLogs.getAll();
        if (allLogRows.size() > 0) {
            for (LogEntry logEntry : allLogRows) {
                String log = toLog(logEntry);
                logger.info("Browser log: {}", log);
            }
        }
    }

    private static String toLog(LogEntry entry) {
        Date date = new Date(entry.getTimestamp());
        return date + " | [" + entry.getLevel() + "] | " + entry.getMessage();
    }
}
