package com.capitole.capitoletests.web.steps;

import com.capitole.capitoletests.frameworkauto.utils.TestContext;
import com.capitole.capitoletests.web.pages.WikipediaPage;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;

public class WikipediaPageSteps {
    private WikipediaPage wikipediaPage;

    public WikipediaPageSteps(final TestContext testContext) throws Exception {
        wikipediaPage = new WikipediaPage(testContext.getDriverManager().getWebDriver());
    }

    @Then("The year of the first automation process on the Wikipedia page should be {string}")
    public void theYearOfTheFirstAutomationProcessOnTheWikipediaPageShouldBe(final String year) {
        Assertions.assertTrue(wikipediaPage.verifyYear(year),
                "The first automation process should have been done in " + year +
                        ", but it is not");
    }
}
