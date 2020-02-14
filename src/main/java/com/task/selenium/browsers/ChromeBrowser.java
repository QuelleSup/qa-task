package com.task.selenium.browsers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.util.logging.Logger;

import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.setWebDriver;
import static com.task.selenium.utils.OSValidator.*;

public class ChromeBrowser {

   private static final Logger LOG = Logger.getLogger(ChromeBrowser.class.getName());

   private static void setUpChromeBrowserForOS() {
      File driver = null;
      if(isMac()) {
         driver = setupWebDriver("src/main/resources/drivers/mac/chromedriver");
      } else if(isWindows()) {
         driver = setupWebDriver("src/main/resources/drivers/win/chromedriver.exe");
      } else if(isLinux()) {
         driver = setupWebDriver("src/main/resources/drivers/linux/chromedriver");
      }
      if (driver != null) {
         System.setProperty("webdriver.chrome.driver", driver.getAbsolutePath());
      }
   }

   private static File setupWebDriver(String driverPath) {
      return new File(driverPath);
   }

   public static void configureChromeBrowser() {
      LOG.info("Setting up Chrome browser..");
      setUpChromeBrowserForOS();
      WebDriver driver = new ChromeDriver();
      getWebDriver().manage().window().maximize();
      driver.get("http://phptravels.net/home");
      setWebDriver(driver);
   }

   public static void shutdown() {
      LOG.info("Shutting down WebDriver");
      WebDriver driver = getWebDriver();
      driver.quit();
   }
}
