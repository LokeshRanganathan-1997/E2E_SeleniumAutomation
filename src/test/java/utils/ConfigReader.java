package utils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

    public static String getProperty(String key) {

        Properties prop = new Properties();

        try {
            FileInputStream file = new FileInputStream("config.properties");
            prop.load(file);
            file.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return prop.getProperty(key);
    }
}