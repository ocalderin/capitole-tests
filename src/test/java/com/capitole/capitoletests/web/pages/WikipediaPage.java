package com.capitole.capitoletests.web.pages;

import com.capitole.capitoletests.frameworkauto.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaPage extends BasePage {
    public WikipediaPage(final WebDriver driver) {
        super(driver);
    }

    public boolean verifyYear(final String year) {
        highlightElement(By.className("mw-page-title-main"));
        return false;
    }
}
