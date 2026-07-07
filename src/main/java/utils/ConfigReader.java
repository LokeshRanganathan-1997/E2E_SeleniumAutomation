package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigReader {

    // Object to store all values from config.properties
    Properties properties;

    // Constructor
    public ConfigReader() {

        properties = new Properties();

        try {

            // Read config.properties file
            FileInputStream file = new FileInputStream(
                    "src/test/resources/config.properties");

            // Load all values into Properties object
            properties.load(file);

        } catch (IOException e) {

            e.printStackTrace();
        }
    }

    // Read value using key
    public String getProperty(String key) {

        return properties.getProperty(key);

    }

}