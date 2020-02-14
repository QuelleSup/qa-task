package com.task.selenium.runners;

import com.task.selenium.browsers.ChromeBrowser;
import org.junit.AfterClass;
import org.junit.BeforeClass;


public class TestRunner {

   @BeforeClass
   public static void setUp() {
      ChromeBrowser.configureChromeBrowser();
   }

   @AfterClass
   public static void tearDown() {
      ChromeBrowser.shutdown();
   }

}
