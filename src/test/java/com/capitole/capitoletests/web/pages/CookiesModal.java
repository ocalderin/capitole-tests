package com.capitole.capitoletests.web.pages;

import com.capitole.capitoletests.frameworkauto.web.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookiesModal extends BasePage {
    private final By cookiesModalBy = By.id("CXQnmb");
    private final By acceptAllButtonBy = By.id("L2AGLb");
    public CookiesModal(WebDriver driver) {
        super(driver);
    }

    public boolean isDisplayed() {
        return isElementDisplayed(cookiesModalBy);
    }

    public void acceptAll() {
        final WebElement consentDialog = driver.findElement(cookiesModalBy);
        click(consentDialog.findElement(acceptAllButtonBy));
    }

}
