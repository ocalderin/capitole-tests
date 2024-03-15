package com.capitole.capitoletests.frameworkauto.utils;

import com.capitole.capitoletests.frameworkauto.web.WebDriverManager;

public class TestContext {
    private WebDriverManager driverManager;

    public TestContext() {
        driverManager = new WebDriverManager();
    }

    public WebDriverManager getDriverManager() {
        return driverManager;
    }

    public void setDriverManager(WebDriverManager driverManager) {
        this.driverManager = driverManager;
    }
}
