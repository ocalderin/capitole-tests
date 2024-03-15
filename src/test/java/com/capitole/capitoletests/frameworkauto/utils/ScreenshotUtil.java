package com.capitole.capitoletests.frameworkauto.utils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class ScreenshotUtil {
    public static byte[] saveScreenshotFile(final WebDriver driver, final String filename) throws IOException {
        byte[] screenshotBytes = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        File capture = new File("images", String.format("%s.png", filename));
        FileOutputStream sout = new FileOutputStream(capture);
        sout.write(screenshotBytes);
        sout.close();
        return screenshotBytes;
    }
}
