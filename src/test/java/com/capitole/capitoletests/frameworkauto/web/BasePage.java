package com.capitole.capitoletests.frameworkauto.web;

import com.capitole.capitoletests.frameworkauto.utils.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class BasePage {
    protected WebDriver driver;
    private static final Logger logger = LoggerFactory.getLogger(BasePage.class);
    private WebDriverWait wait;
    private JavascriptExecutor javascriptExecutor;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        javascriptExecutor = (JavascriptExecutor) driver;
    }

    public void navigateTo(final String url) {
        driver.get(url);
    }

    public  <T> void waitElement(final T elementAttr) {
        waitElement(elementAttr, Constants.DEFAULT_TIMEOUT);
    }

    public <T> void waitElement(final T elementAttr, final int timeout) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        if (elementAttr
                .getClass()
                .getName()
                .contains("By")) {
            wait.until(ExpectedConditions.presenceOfElementLocated((By) elementAttr));
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
        }
    }

    public  <T> void waitElements(final T elementAttr) {
        waitElements(elementAttr, Constants.DEFAULT_TIMEOUT);
    }

    public  <T> void waitElements(final T elementAttr, final int timeout) {
        wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        if (elementAttr
                .getClass()
                .getName()
                .contains("By")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) elementAttr));
        } else {
            wait.until(ExpectedConditions.visibilityOfAllElements((WebElement) elementAttr));
        }
    }

    public <T> void click(final T elementAttr) {
        click(elementAttr, Constants.DEFAULT_TIMEOUT);
    }

    public <T> void click(final T elementAttr, final int timeout) {
        waitElement(elementAttr, timeout);
        WebElement element;
        if (elementAttr
                .getClass()
                .getName()
                .contains("By")) {
            element = driver.findElement((By) elementAttr);
        } else {
            element = ((WebElement) elementAttr);
        }
        scrollIntoView(element);
        element.click();
    }

    public void scrollIntoView(final WebElement element) {
        javascriptExecutor.executeScript(Constants.SCROLL_INTO_VIEW_SCRIPT, element);
    }

    public <T> void writeText(final T elementAttr, final String text) {
        writeText(elementAttr, text, Constants.DEFAULT_TIMEOUT);
    }

    public <T> void writeText(final T elementAttr, final String text, final int timeout) {
        waitElement(elementAttr, timeout);
        if (elementAttr
                .getClass()
                .getName()
                .contains("By")) {
            wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy((By) elementAttr));
            driver
                    .findElement((By) elementAttr)
                    .sendKeys(text);
        } else {
            wait.until(ExpectedConditions.visibilityOf((WebElement) elementAttr));
            ((WebElement) elementAttr).sendKeys(text);
        }
    }

    public <T> String readText(final T elementAttr) {
        return readText(elementAttr, Constants.DEFAULT_TIMEOUT);
    }

    public <T> String readText(final T elementAttr, final int timeout) {
        waitElement(elementAttr, timeout);
        if (elementAttr
                .getClass()
                .getName()
                .contains("By")) {
            return driver
                    .findElement((By) elementAttr)
                    .getText();
        } else {
            return ((WebElement) elementAttr).getText();
        }
    }

    public <T> boolean isElementDisplayed(final T elementAttr) {
        return isElementDisplayed(elementAttr, Constants.DEFAULT_TIMEOUT);
    }

    public <T> boolean isElementDisplayed(final T elementAttr, final int timeout) {
        try {
            waitElement(elementAttr, timeout);
            WebElement element;
            if (elementAttr
                    .getClass()
                    .getName()
                    .contains("By")) {
                element = driver
                        .findElement((By) elementAttr);
            } else {
                element = (WebElement) elementAttr;
            }

            return element.isDisplayed();
        } catch (Exception e) {
            logger.error("Error looking for error element: "  + e.getMessage());
            return false;
        }
    }

    public <T> void highlightElement(final T elementAttr) {
        WebElement element;
        if (elementAttr
                .getClass()
                .getName()
                .contains("By")) {
            element = driver
                    .findElement((By) elementAttr);
        } else {
            element = (WebElement) elementAttr;
        }
        scrollIntoView(element);
        javascriptExecutor.executeScript(Constants.HIGHLIGHT_ELEMENT_SCRIPT, element);
    }
}
