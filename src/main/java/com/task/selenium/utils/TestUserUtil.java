package com.task.selenium.utils;

import com.task.selenium.entities.User;

import java.io.*;
import java.util.Properties;

import static com.task.selenium.utils.EmailUtil.*;

public final class TestUserUtil {

    private static final String PROPERTIES_PATH = "src/main/resources/test.properties";

    public static void setUserProperties() throws IOException {
        User user = new User("Jack", "White",
                prepareEmailAndLog("%s@dot.com"), "030203405",
                "Welcome1", "FirstAddress1", "SecondAddress2", "Krakow", "Malopolskie", "31-586");

        Properties properties = new Properties();

        properties.put("name", user.getFirstName());
        properties.put("lastname", user.getLastName());
        properties.put("email", user.getEmail());
        properties.put("phone.number", user.getPhoneNumber());
        properties.put("password", user.getPassword());
        properties.put("address1", user.getFirstAddress());
        properties.put("address2", user.getSecondAddress());
        properties.put("city", user.getCity());
        properties.put("state", user.getState());
        properties.put("postal.code", user.getPostalCode());
        FileOutputStream outputStream = new FileOutputStream(PROPERTIES_PATH);

        properties.store(outputStream, "");

    }

    private static Properties readPropertiesFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(PROPERTIES_PATH);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }


    public static User getEmailAndPasswordFromPropertiesFile() throws IOException {
        Properties properties = readPropertiesFile();
        return new User(properties.getProperty("email"), properties.getProperty("password"));
    }

    public static User getAllUserDetailsFromPropertiesFile() throws IOException {
        Properties properties = readPropertiesFile();
        return new User(properties.getProperty("name"),
                properties.getProperty("lastname"),
                properties.getProperty("email"),
                properties.getProperty("phone.number"),
                properties.getProperty("password"),
                properties.getProperty("address1"),
                properties.getProperty("address2"),
                properties.getProperty("city"),
                properties.getProperty("state"),
                properties.getProperty("postal.code"));
    }

}
