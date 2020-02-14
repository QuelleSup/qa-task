package com.task.selenium.runners;

import org.junit.AfterClass;
import org.junit.BeforeClass;

import java.io.IOException;

import static com.task.selenium.browsers.ChromeBrowser.*;
import static com.task.selenium.utils.TestUserUtil.*;

public class TestRunner {

   @BeforeClass
   public static void setUp() throws IOException {
      configureChromeBrowser();
      setUserProperties();
   }

   @AfterClass
   public static void tearDown() {
      shutdown();
   }
}
