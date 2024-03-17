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

    protected void navigateTo(final String url) {
        driver.get(url);
    }

    protected  <T> void waitElement(final T elementAttr) {
        waitElement(elementAttr, Constants.DEFAULT_TIMEOUT);
    }
    protected <T> void waitElement(final T elementAttr, final int timeout) {
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

    protected <T> void click(final T elementAttr) {
        click(elementAttr, Constants.DEFAULT_TIMEOUT);
    }
    protected <T> void click(final T elementAttr, final int timeout) {
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

    protected void scrollIntoView(final WebElement element) {
        javascriptExecutor.executeScript(Constants.SCROLL_INTO_VIEW_SCRIPT, element);
    }

    protected <T> void writeText(final T elementAttr, final String text) {
        writeText(elementAttr, text, Constants.DEFAULT_TIMEOUT);
    }
    protected <T> void writeText(final T elementAttr, final String text, final int timeout) {
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

    protected <T> String readText(final T elementAttr) {
        return readText(elementAttr, Constants.DEFAULT_TIMEOUT);
    }
    protected <T> String readText(final T elementAttr, final int timeout) {
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

    protected <T> boolean isElementDisplayed(final T elementAttr) {
        return isElementDisplayed(elementAttr, Constants.DEFAULT_TIMEOUT);
    }
    protected <T> boolean isElementDisplayed(final T elementAttr, final int timeout) {
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

    protected <T> void highlightElement(final T elementAttr) {
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
