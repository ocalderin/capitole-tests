package com.capitole.capitoletests.web.pages;

import com.capitole.capitoletests.frameworkauto.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleHomePage extends BasePage {
    private final static String URL = "https://www.google.com";

    private final By searchInputBy = By.name("q");
    private final By consentDialogBy = By.id("CXQnmb");
    private final By acceptAllButtonBy = By.id("L2AGLb");

    public GoogleHomePage(final WebDriver driver) {
        super(driver);
    }

    public void goToHomePage() {
        driver.get(URL);
        if (isElementDisplayed(consentDialogBy)) {
            final WebElement consentDialog = driver.findElement(consentDialogBy);
            click(consentDialog.findElement(acceptAllButtonBy));
        }
    }

    public void searchWord(final String word) {
        writeText(searchInputBy, word + Keys.ENTER);
    }
}
