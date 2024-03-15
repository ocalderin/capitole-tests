package com.capitole.capitoletests.runners;

import org.junit.platform.suite.api.*;

import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;

@Suite
@SuiteDisplayName("Web Tests")
@IncludeEngines("cucumber")
@IncludeTags("web")
@SelectClasspathResource("web/features")
@ConfigurationParameter(key = GLUE_PROPERTY_NAME, value = "com.capitole.capitoletests.web")
@ConfigurationParameter(key = PLUGIN_PROPERTY_NAME, value = "json:reports/cucumber-report/web-report.json, " +
        "html:reports/cucumber-report/web-report.html, timeline:reports/cucumber-report/web-timeline-report")
public class RunnerWebTests {
}
