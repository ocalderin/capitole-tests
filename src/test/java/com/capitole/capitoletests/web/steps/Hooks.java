package com.capitole.capitoletests.web.steps;

import com.capitole.capitoletests.frameworkauto.utils.FileUtils;
import com.capitole.capitoletests.frameworkauto.utils.ScreenshotUtil;
import com.capitole.capitoletests.frameworkauto.utils.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Hooks {
    private TestContext testContext;
    private static final Logger logger = LoggerFactory.getLogger(Hooks.class);

    public Hooks(final TestContext testContext) {
        this.testContext = testContext;
    }

    @After
    public void tearDown(Scenario scenario) {
        try {
            byte[] screenshot = ScreenshotUtil.saveScreenshotFile(testContext.getDriverManager().getWebDriver(),
                    FileUtils.formatScenarioName(scenario.getName()));
            scenario.attach(screenshot, "image/png", scenario.getName());
        } catch (Exception e) {
            logger.error("Error taking screenshot: " + e.getMessage());
        }
        testContext.getDriverManager().quitWebDriver();
    }
}
