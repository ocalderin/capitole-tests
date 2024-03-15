package com.capitole.capitoletests.web.steps;

import com.capitole.capitoletests.frameworkauto.utils.TestContext;
import io.cucumber.java.After;

public class Hooks {
    private TestContext testContext;
    public Hooks(TestContext testContext) {
        this.testContext = testContext;
    }

    @After
    public void tearDown() {
        testContext.getDriverManager().quitWebDriver();
    }
}
