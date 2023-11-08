package com.nnga.projects.pages;

import com.nnga.resources.Resources;
import com.nnga.utils.logs.Log;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class CreateAdminPage {
    private WebDriver driver;
    private Resources resources;
    Actions action;
    public CreateAdminPage(WebDriver driver){
        this.driver = driver;
        resources = new Resources(driver);
        action = new Actions(driver);
    }
    private By userRoleDropdown = By.xpath("//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[1]//div[1]//div[2]//div[1]//div[1]//div[2]//i[1]");
    private String userRoleValue = "Admin";
    private By userRoleText = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]");
    private By employeeNameInput = By.xpath("//input[@placeholder='Type for hints...']");
    private String employeeNameValue = "a";
    private By statusDropdown = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[2]");
    private String statusValue = "Enabled";
    private By statusText = By. xpath(" //div[contains(text(),'Enabled')]");
    private By usernameInput = By.xpath("//div[@class='oxd-form-row']//div[@class='oxd-grid-2 orangehrm-full-width-grid']//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private String usernameValue = "nnga1223399";
    private By userNameInvalidText = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
    private By passwordInput = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters user-password-cell']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private String passwordValue = "nga12345";
    private By confirmPasswordInput = By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']");
    private String confirmPasswordValue = "nga12345";
    private By notMatchPasswordText = By.xpath("//span[@class='oxd-text oxd-text--span oxd-input-field-error-message oxd-input-group__message']");
    private By saveButton = By.xpath("//button[normalize-space()='Save']");
    private By usernameSearchInput= By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private By searchButton = By.xpath("//button[normalize-space()='Search']");
    private By resultForSearchText = By.xpath("//span[normalize-space()='(1) Record Found']");
   public void sendUserRole(){
        resources.clickElement(userRoleDropdown);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        Assert.assertEquals(driver.findElement(userRoleText).getText(),userRoleValue);
    }
    public void sendEmployeeName(){
        resources.setText(employeeNameInput, employeeNameValue);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
    }
    public void sendStatus(){
        resources.clickElement(statusDropdown);
        action.sendKeys(Keys.ARROW_DOWN).build().perform();
        action.sendKeys(Keys.ENTER).build().perform();
        Assert.assertEquals(driver.findElement(statusText).getText(),statusValue);
    }
    public void sendUsername(){
        resources.setText(usernameInput, usernameValue);
    }
    public void sendPassword(){
        resources.setText(passwordInput,passwordValue);
        resources.setText(confirmPasswordInput, confirmPasswordValue);
        if(resources.elementIsDisplay(notMatchPasswordText)){
            Log.error("Password not match");
        }
        resources.clickElement(saveButton);
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public void checkCreate(){
        resources.setText(usernameSearchInput, usernameValue);
        resources.clickElement(searchButton);
        String result = resources.getText(resultForSearchText);
        Assert.assertTrue(result.contains("(1) Record Found"));
        List<WebElement> test = driver.findElements(By.xpath("//div[@role='table']"));
        for(int i = 1; i < test.size() + 1; i ++){
            WebElement usernameItems = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div["+ i +"]/div[1]/div[2]"));
            Assert.assertEquals(usernameItems.getText(), usernameValue);
       }

    }
}
