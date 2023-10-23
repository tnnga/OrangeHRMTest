package com.nnga.projects.pages;

import com.nnga.resources.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class CreateAdminPage {
    private WebDriver driver;
    private Resources resources;
    public CreateAdminPage(WebDriver driver){
        this.driver = driver;
        resources = new Resources(driver);
    }
    private By userRoleDropdown = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]");
    private By userRoleGetValue = By.xpath("//div[@role='listbox']//li[contains(text(),'Admin')]");
    private String userRoleValue = "Admin";
    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private String employeeNameValue = "Nguyen Thi Thuy Nga";
    public void sendUserRole(){
        resources.clickElement(userRoleDropdown);
        resources.clickElement(userRoleGetValue);

        Assert.assertEquals(driver.findElement(userRoleDropdown).getText(),userRoleValue);
    }
    public void sendEmployeeName(){
        resources.setText(employeeNameInput, employeeNameValue);

        Assert.assertEquals(driver.findElement(employeeNameInput).getAttribute("placeholder"),employeeNameValue);
    }
}
