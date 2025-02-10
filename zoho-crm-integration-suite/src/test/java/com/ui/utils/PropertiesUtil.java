package com.ui.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesUtil {

    private static Properties properties;

    static {
        try (FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"//config//locators.properties")){
            properties = new Properties();
            properties.load(fis);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load properties file.");
        }
    }

    public static String getProperty(String key) {
        return properties.getProperty(key);
    }
}
