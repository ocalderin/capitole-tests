package com.capitole.capitoletests.web.pages;

import com.capitole.capitoletests.frameworkauto.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Optional;

public class GoogleResultsPage extends BasePage {
    private final static String WIKIPEDIA_TITLE = "Wikipedia, la enciclopedia libre";
    private final By resultBy = By.className("g");
    private final By resultTitleBy = By.tagName("h3");
    public GoogleResultsPage(final WebDriver driver) {
        super(driver);
    }

    public void openWikipedia() throws Exception {
        waitElements(resultBy);
        final Optional<WebElement> link = driver.findElements(resultBy).stream()
                .filter(e -> e.findElement(resultTitleBy).getText().contains(WIKIPEDIA_TITLE)).findFirst();
        if (link.isPresent())
            click(link.get());
        else throw new Exception("The Wikipedia link related to the searched word could not be found");
    }
}
