package com.task.selenium.utils;

import java.io.*;
import java.util.Properties;

public class TestUserUtil {

    public static void setTestUserProps() {
        File file = new File("src/main/resources/test.properties");

        Properties prop = new Properties();

        try (InputStream in = new FileInputStream(file)) {
            prop.load(in);
            prop.setProperty("email", EmailUtil.prepareEmailAndLog("%s@simulated.com"));
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

}
