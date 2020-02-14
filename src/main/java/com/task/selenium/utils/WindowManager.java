package com.task.selenium.utils;

import com.task.selenium.stepdefs.HomePageStepdefs;
import org.openqa.selenium.WebDriver;

import java.util.Set;
import java.util.logging.Logger;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static java.lang.Thread.sleep;

public final class WindowManager {

    private static final Logger LOG = Logger.getLogger(HomePageStepdefs.class.getName());

    public static boolean isWindowContainingUrlOpen(String partialUrl) {
        boolean isOpen = false;
        WebDriver driver = getWebDriver();
        Set<String> windowHandles = driver.getWindowHandles();
        String originalWindow = driver.getWindowHandle();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().contains(partialUrl)) {
                isOpen = true;
                break;
            }
        }
        driver.switchTo().window(originalWindow);
        return isOpen;
    }

    public static void switchToWindowWithUrlContaining(String partialUrl) {
        try {
            sleep(1000);
        } catch (InterruptedException e) {
            LOG.warning("Execution pausing for " + 1000 + " thrown exception");
        }
        WebDriver driver = getWebDriver();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String windowHandle : windowHandles) {
            driver.switchTo().window(windowHandle);
            if (driver.getCurrentUrl().contains(partialUrl)) {
                LOG.info("Switched to window: " + driver.getTitle() + " URL: " + url());
                return;
            }
        }
        throw new IllegalArgumentException("Window with url not found: " + partialUrl);
    }
}
