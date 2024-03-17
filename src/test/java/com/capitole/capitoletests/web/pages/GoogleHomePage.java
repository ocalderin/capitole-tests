package com.capitole.capitoletests.web.pages;

import com.capitole.capitoletests.frameworkauto.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class GoogleHomePage extends BasePage {
    private final static String URL = "https://www.google.com";
    private final By searchInputBy = By.name("q");
    private CookiesModal cookiesModal;

    public GoogleHomePage(final WebDriver driver) {
        super(driver);
        cookiesModal = new CookiesModal(driver);
    }

    public void goToHomePage() {
        navigateTo(URL);
        if (cookiesModal.isDisplayed()) {
            cookiesModal.acceptAll();
        }
    }

    public void searchWord(final String word) {
        writeText(searchInputBy, word + Keys.ENTER);
    }
}
