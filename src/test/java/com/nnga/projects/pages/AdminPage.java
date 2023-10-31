package com.nnga.projects.pages;

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
    private By addAdminButton = By.xpath("//button[normalize-space()='Add']");
    private String urlAddAdmin = "/admin/saveSystemUser";

    public void openAdminPage() {
        resources.clickElement(adminButton);
        Assert.assertTrue(resources.vertifyUrl(urlAdminPage), "not in Admin Page");
    }

    public CreateAdminPage openAddAdminForm() {
        resources.clickElement(addAdminButton);
        Assert.assertTrue(resources.vertifyUrl(urlAddAdmin), "not in Add Admin Form");
        return new CreateAdminPage(driver);
    }
}
