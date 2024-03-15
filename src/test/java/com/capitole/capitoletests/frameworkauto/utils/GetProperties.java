package com.capitole.capitoletests.frameworkauto.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperties {
    private final Properties prop = new Properties();
    private static final Logger logger = LoggerFactory.getLogger(GetProperties.class);

    public GetProperties(){
        final String propertiesFile = "/config.properties";
        final InputStream in = getClass().getResourceAsStream(propertiesFile);
        try {
            prop.load(in);
        }
        catch (FileNotFoundException e) {
        logger.error("The property file was not found");
        }
        catch (IOException e) {
        logger.error("Can not read property file");
      }
    }

    public String getBrowser() {
        return prop.getProperty("browser");
    }
}
