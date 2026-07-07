package tests;

import org.testng.annotations.Test;

import utils.ConfigReader;

public class ConfigTest {

    @Test
    public void readConfig() {

        ConfigReader config = new ConfigReader();

        System.out.println(config.getProperty("browser"));
        System.out.println(config.getProperty("url"));
        System.out.println(config.getProperty("email"));
        System.out.println(config.getProperty("password"));
    }
}