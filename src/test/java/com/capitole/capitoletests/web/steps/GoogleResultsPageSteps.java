package com.capitole.capitoletests.web.steps;

import com.capitole.capitoletests.frameworkauto.utils.TestContext;
import com.capitole.capitoletests.web.pages.GoogleResultsPage;
import io.cucumber.java.en.And;

public class GoogleResultsPageSteps {
    private GoogleResultsPage googleResultsPage;

    public GoogleResultsPageSteps(final TestContext testContext) throws Exception {
        googleResultsPage = new GoogleResultsPage(testContext.getDriverManager().getWebDriver());
    }

    @And("the user selects the Wikipedia result")
    public void theUserSelectsTheWikipediaResult() throws Exception {
        googleResultsPage.openWikipedia();
    }
}
