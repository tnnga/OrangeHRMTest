package com.nnga.utils.helpers;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CaptureHelper {
    static String projectPath = System.getProperty("user.dir") + "/";
    private static SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");

    public static void captureScreenshot(WebDriver driver, String screenName) {
        PropertiesFileHelper.setPropertiesFile();
        try {
            Reporter.log("Driver for Screenshot: " + driver);
            TakesScreenshot ts = (TakesScreenshot) driver;
            File source = ts.getScreenshotAs(OutputType.FILE);
            File theDir = new File(projectPath + PropertiesFileHelper.getPropValue("exportCapturePath"));
            if (!theDir.exists()){
                theDir.mkdirs();
            }
            FileHandler.copy(source, new File(projectPath + PropertiesFileHelper.getPropValue("exportCapturePath") + "/" + screenName + "_" + dateFormat.format(new Date()) + ".png"));
            System.out.println("Screenshot taken: " + screenName);
            Reporter.log("Screenshot taken current URL: " + driver.getCurrentUrl(), true);
        } catch (Exception e) {
            System.out.println("Exception while taking screenshot: " + e.getMessage());
        }

    }
}
