package com.capitole.capitoletests.frameworkauto.web;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class OptionsManager {
    private static final Logger logger = LoggerFactory.getLogger(OptionsManager.class);
    private static final boolean HEADLESS = Boolean.parseBoolean(System.getProperty("headless", "false"));
    public static ChromeOptions ChromeOptions() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--no-sandbox");
        chromeOptions.addArguments("--disable-extensions");
        if (HEADLESS) {
            logger.info("Running tests on HEADLESS mode");
            chromeOptions.addArguments("--headless=new");
        }
        return chromeOptions;
    }

    public static FirefoxOptions FirefoxOptions() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        if (HEADLESS) {
            logger.info("Running tests on HEADLESS mode");
            firefoxOptions.addArguments("--headless");
        }
        return firefoxOptions;
    }

    public static EdgeOptions EdgeOptions() {
        EdgeOptions edgeOptions = new EdgeOptions();
        if (HEADLESS) {
            logger.info("Running tests on HEADLESS mode");
            edgeOptions.addArguments("--headless");
        }
        return edgeOptions;
    }
}

