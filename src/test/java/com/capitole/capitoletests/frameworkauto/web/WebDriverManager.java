package com.capitole.capitoletests.frameworkauto.web;

import com.capitole.capitoletests.frameworkauto.utils.GetProperties;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.capitole.capitoletests.frameworkauto.utils.Constants;
import org.openqa.selenium.WebDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class WebDriverManager {
    protected GetProperties getProperties = new GetProperties();
    private WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(WebDriverManager.class);

    public WebDriver getWebDriver() throws Exception {
        if (driver == null) {
            final String env = System.getProperty("exec", "local");
            final String browser = getProperties.getBrowser();
            logger.info("Browser selected: " + browser);
            if ("local".equals(env)) {
                logger.info("Running tests locally");
                driver = createDriver(browser);
            } else if ("remote".equals(env)) {
                logger.info("Running tests remotely");
                driver = createRemoteDriver(browser);
            } else {
                throw new Exception("Invalid environment selected. Please use locar or remote");
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.DEFAULT_TIMEOUT));
            return driver;
        }
        return driver;
    }

    private WebDriver createDriver(String browser) {
        return switch (browser) {
            case "firefox" -> new FirefoxDriver(OptionsManager.FirefoxOptions());
            case "edge" -> new EdgeDriver(OptionsManager.EdgeOptions());
            case "safari" -> new SafariDriver();
            default -> new ChromeDriver(OptionsManager.ChromeOptions());
        };
    }

    private WebDriver createRemoteDriver(String browser) throws MalformedURLException {
        logger.info("Browser selected: " + browser);
        final String hubUri = Constants.HUB_URL;
        return switch (browser) {
            case "firefox" -> new RemoteWebDriver(new URL(hubUri), OptionsManager.FirefoxOptions());
            case "edge" -> new RemoteWebDriver(new URL(hubUri), OptionsManager.EdgeOptions());
            default -> new RemoteWebDriver(new URL(hubUri), OptionsManager.ChromeOptions());
        };
    }
    public void quitWebDriver() {
        if (driver != null) {
            driver.quit();
        }
    }
}
