package com.nnga.projects.pages;

import com.nnga.resources.Resources;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.List;

public class AdminPage {
    WebDriver driver;
    private Resources resources;
    private Actions actions;

    public AdminPage(WebDriver driver) {
        this.driver = driver;
        resources = new Resources(driver);
        actions = new Actions(driver);
    }

    private By adminButton = By.xpath("//ul[@class='oxd-main-menu']//span[contains(.,'Admin')]");
    private String urlAdminPage = "/admin/viewSystemUsers";
    private By addAdminButton = By.xpath("//button[normalize-space()='Add']");
    private String urlAddAdmin = "/admin/saveSystemUser";
    private By resetButtonInput = By.xpath("//button[normalize-space()='Reset']");
    private By usernameInput = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
    private By userRoleInput = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]");
    private By employeeNameInput = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/input[1]");
    private By statusInput = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[4]/div[1]/div[2]/div[1]/div[1]/div[2]/i[1]");
    private By searchButton = By.xpath("//button[normalize-space()='Search']");
    private By resultForSearchText = By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[2]/div[1]/span[1]");
    public void openAdminPage() {
        resources.clickElement(adminButton);
        Assert.assertTrue(resources.vertifyUrl(urlAdminPage), "not in Admin Page");
    }

    public CreateAdminPage openAddAdminForm() {
        resources.clickElement(addAdminButton);
        Assert.assertTrue(resources.vertifyUrl(urlAddAdmin), "not in Add Admin Form");
        return new CreateAdminPage(driver);
    }
    public void searchAndResetEmployee(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        //resources.clickElement(resetButtonInput);
        String resultBeforeSearch = resources.getText(resultForSearchText);
        String usernameForSearch = "";
        for(int i = 2; i < 6; i++) {
            WebElement value = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div[1]/div[1]/div[" + i + "]/div[1]"));
            switch (i){
                case 2:
                    resources.setText(usernameInput, value.getText());
                    usernameForSearch = value.getText();
                case 3:
                    resources.clickElement(userRoleInput);
                    if(value.getText().contains("Admin")){
                        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                    } else if (value.getText().contains("ESS")) {
                        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                    }
                case 4:
                    //resources.setText(employeeNameInput, value.getText());
                case 5:
                    resources.clickElement(statusInput);
                    if(value.getText().contains("Enabled")){
                        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                    } else if (value.getText().contains("Disabled")) {
                        actions.sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ENTER).build().perform();
                    }
            }
        }
        resources.clickElement(searchButton);
        String resultSearch = resources.getText(resultForSearchText);
        Assert.assertTrue(resultSearch.contains("(1) Record Found"));
        List<WebElement> test = driver.findElements(By.xpath("//div[@role='table']"));
        for(int i = 1; i < test.size() + 1; i ++){
            WebElement usernameItems = driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[2]/div[3]/div[1]/div[2]/div["+ i +"]/div[1]/div[2]"));
            Assert.assertEquals(usernameItems.getText(), usernameForSearch);
        }
        resources.clickElement(resetButtonInput);
        Assert.assertEquals(driver.findElement(usernameInput).getText(),"");
        Assert.assertEquals(driver.findElement(userRoleInput).getText(), "");
        Assert.assertEquals(driver.findElement(employeeNameInput).getAttribute("placeholder"),"Type for hints...");
        Assert.assertEquals(driver.findElement(statusInput).getText(), "");

        String resultAfterReset = resources.getText(resultForSearchText);
        Assert.assertEquals(resultBeforeSearch,resultAfterReset);
    }
    public EditEmployeePage openEditEmployeeForm(){

        return new EditEmployeePage(driver);
    }
    public void deleteEmployee(){

    }
}
