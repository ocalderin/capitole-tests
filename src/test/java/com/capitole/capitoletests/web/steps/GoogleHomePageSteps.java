package com.capitole.capitoletests.web.steps;

import com.capitole.capitoletests.frameworkauto.utils.TestContext;
import com.capitole.capitoletests.web.pages.GoogleHomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class GoogleHomePageSteps {
    private GoogleHomePage googleHomePage;

    public GoogleHomePageSteps(final TestContext testContext) throws Exception {
        googleHomePage = new GoogleHomePage(testContext.getDriverManager().getWebDriver());
    }

    @Given("The user goes to the Google homepage")
    public void theUserGoesToTheGoogleHomePage() {
        googleHomePage.goToHomePage();
    }

    @When("The user searches for the word {string}")
    public void theUserSearchesForTheWord(final String word) {
        googleHomePage.searchWord(word);
    }
}
