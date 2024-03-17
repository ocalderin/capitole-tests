package com.capitole.capitoletests.web.pages;

import com.capitole.capitoletests.frameworkauto.utils.Constants;
import com.capitole.capitoletests.frameworkauto.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WikipediaPage extends BasePage {
    private final By bodyBy = By.tagName("body");
    private final By paragraphBy = By.xpath("//*[@id='cite_ref-27']/..");
    public WikipediaPage(final WebDriver driver) {
        super(driver);
    }

    public boolean verifyYear(final String year) {
        highlightElement(paragraphBy);
        return readText(bodyBy).contains(String.format(Constants.FIRST_AUTOMATIC_PROCESS_YEAR_TEXT, year));
    }
}
