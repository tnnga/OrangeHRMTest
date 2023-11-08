package com.nnga.projects.testcases;

import com.nnga.browsers.BaseSetupMulti;
import com.nnga.projects.pages.AdminPage;
import com.nnga.projects.pages.CreateAdminPage;
import com.nnga.projects.pages.SignInPage;
import com.nnga.utils.helpers.CaptureHelper;
import com.nnga.utils.logs.Log;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.nnga.resources.Resources;

public class AdminTest extends BaseSetupMulti {
    WebDriver driver;
    private AdminPage adminPage;
    private SignInPage signInPage;
    private CreateAdminPage createAdminPage;
    private Resources resources;


    @BeforeClass
    public void setUp() {
        driver = new BaseSetupMulti().setupDriver("chrom");
        resources = new Resources(driver);
    }
    @Test(priority = 0)
    public void gotoBrower(){
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test (priority = 1, description = "Sign in page")
    public void signPage() {
        signInPage = new SignInPage(driver);
        adminPage = signInPage.SignIn("Admin", "admin123");
    }

    @Test (priority = 2)
    public void showAdminPage() {
        adminPage.openAdminPage();
        //createAdminPage = adminPage.openAddAdminForm();
    }
    @Test(priority = 4)
    public void createAdmin(){
        createAdminPage.sendUserRole();
        createAdminPage.sendEmployeeName();
        createAdminPage.sendStatus();
        createAdminPage.sendUsername();
        createAdminPage.sendPassword();
        createAdminPage.checkCreate();
    }
    @Test(priority = 3)
    public void searchEmployee(){
        adminPage.searchAndResetEmployee();
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
