package com.task;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestProperties {

    private static final String PROPERTIES_PATH = "src/test/resources/api.properties";

    private static Properties readPropertiesFile() throws IOException {
        FileInputStream fileInputStream = new FileInputStream(PROPERTIES_PATH);
        Properties properties = new Properties();
        properties.load(fileInputStream);
        return properties;
    }

    public static String getProperty(String propertyName) throws IOException {
        return readPropertiesFile().getProperty(propertyName);
    }

}
