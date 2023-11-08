package com.nnga.projects.testcases;

import com.nnga.browsers.BaseSetupForXML;
import com.nnga.browsers.BaseSetupMulti;
import com.nnga.utils.helpers.CaptureHelper;
import com.nnga.utils.helpers.RecordVideo;
import com.nnga.utils.helpers.ExcelFileHelper;
import com.nnga.utils.helpers.PropertiesFileHelper;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.nnga.projects.pages.SignInPage;
import com.nnga.resources.Resources;

public class SignInTest extends BaseSetupForXML {
    private WebDriver driver;
    private SignInPage signInPage;
    private ExcelFileHelper excelHelpers;
    private Resources resources;
    @BeforeClass
    public void setUp(){
        driver = new BaseSetupMulti().setupDriver("chrom");
        resources = new Resources(driver);
        excelHelpers = new ExcelFileHelper();
        PropertiesFileHelper.setPropertiesFile();
        resources = new Resources(driver);
    }
    @Test(priority = 0)
    public void gotoBrower(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }
    @Test(priority = 1)
    public void signPage() {
        //excelHelpers.setExcelFile("src/test/DataResources/DataTest.xlsx","Sheet1");
        signInPage = new SignInPage(driver);
        //signInPage.SignIn(excelHelpers.getCellData("Username",1), excelHelpers.getCellData("Password", 1));
        //excelHelpers.setCellData("Admin123", 3, 4);
        signInPage.SignIn(PropertiesFileHelper.getPropValue("username"), PropertiesFileHelper.getPropValue("password"));

        System.out.println("Login thành công");
    }

    @AfterMethod
    public void takeScreenshot(ITestResult result) {
        resources.waitForPageLoaded();

        if (ITestResult.FAILURE == result.getStatus()) {
            try {
                CaptureHelper.captureScreenshot(driver, result.getName());
            } catch (Exception e) {
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
    }
}