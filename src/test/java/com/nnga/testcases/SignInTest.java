package com.nnga.testcases;

import com.nnga.commons.BaseSetup;
import com.nnga.resources.ExcelHelpers;
import com.nnga.resources.PropertiesFile;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

import com.nnga.pages.SignInPage;

public class SignInTest extends BaseSetup {
    private WebDriver driver;
    private SignInPage signInPage;
    ExcelHelpers excelHelpers;

    @BeforeClass
    public void setUpBrowser() {
        driver = getDriver();
        excelHelpers = new ExcelHelpers();
        PropertiesFile.setPropertiesFile();
    }

    @Test
    public void signPage() throws Exception {
        //excelHelpers.setExcelFile("src/test/DataResources/DataTest.xlsx","Sheet1");
        signInPage = new SignInPage(driver);
        //signInPage.SignIn(excelHelpers.getCellData("Username",1), excelHelpers.getCellData("Password", 1));
        //excelHelpers.setCellData("Admin123", 3, 4);
        signInPage.SignIn(PropertiesFile.getPropValue("username"), PropertiesFile.getPropValue("password"));
        System.out.println("Login thành công");
        System.out.println("Login thành công");
        
    }
}