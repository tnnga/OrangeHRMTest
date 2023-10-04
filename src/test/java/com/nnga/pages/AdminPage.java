package com.nnga.pages;

import com.nnga.resources.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AdminPage {
    WebDriver driver;
    private Resources resources;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        resources = new Resources(driver);
    }

    private By adminButton = By.xpath("//ul[@class='oxd-main-menu']//span[contains(.,'Admin')]");
    private String urlAdminPage = "/admin/viewSystemUsers";

    public void openAdminPage() {
        resources.clickElement(adminButton);
        boolean vertifyUrl = resources.vertifyUrl(urlAdminPage);
        Assert.assertTrue(vertifyUrl, "not in Admin Page");
    }
}
