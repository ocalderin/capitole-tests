package com.capitole.capitoletests.frameworkauto.utils;

public class FileUtils {
    private static final String REGEX = "[^a-zA-Z0-9]";

    public static String formatScenarioName(final String scenarioName) {
        String cleanedName = scenarioName.replaceAll(REGEX, "_");
        int maxLength = 50;
        if (cleanedName.length() > maxLength) {
            cleanedName = cleanedName.substring(0, maxLength);
        }
        return cleanedName;
    }
}
