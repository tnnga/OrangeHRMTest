import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;

public class NewTest {
    WebDriver chromDriver;

    @BeforeTest
    public void Setup(){
        chromDriver = new ChromeDriver();
        chromDriver.navigate().to("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        chromDriver.manage().window().maximize();
        Sleep(1000);
    }
    @Test (priority = 0)
    public void Login(){
        WebElement txtUsername = chromDriver.findElement(By.xpath("//input[@placeholder='Username']"));
        SendText(txtUsername, "Admin");
        Sleep(200);

        WebElement txtPassword = chromDriver.findElement(By.xpath("//input[@placeholder='Password']"));
        SendText(txtPassword, "admin123");
        Sleep(200);

        WebElement btnLogin = chromDriver.findElement(By.xpath("//button[normalize-space()='Login']"));
        Click(btnLogin);
        Sleep(3000);

        System.out.println("Test login success");
    }
    @Test (priority = 1)
    public void AddAdmin(){
        WebElement btnAdmin = chromDriver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]"));
        Click(btnAdmin);
        Sleep(1000);

        WebElement lblAdmin = chromDriver.findElement(By.xpath("//header/div[1]/div[1]/span[1]"));
        String lblAdminText = lblAdmin.getText() ;
        Assert.assertTrue(lblAdminText.contains("Admin"), "Khong phai trang Admin");
        Sleep(200);

        WebElement btnAdd = chromDriver.findElement(By.xpath("//button[normalize-space()='Add']"));
        Click(btnAdd);
        Sleep(200);

        System.out.println("Add admin success");
    }
    @Test (priority = 2)
    public void CheckBoxAdmin() throws AWTException {
        WebElement test = chromDriver.findElement(By.xpath(""));
        Actions action = new Actions(chromDriver);
        action.doubleClick(test).build().perform();
        action.sendKeys(test,"A").build().perform();
        action.sendKeys(test,"A").build().perform();

        Robot robot = new Robot();
        System.out.println("Check box admin");
    }

    public void SendText(WebElement webElement, String text){
        webElement.clear();
        Assert.assertTrue(webElement.isDisplayed() && webElement.isEnabled(), "Khong the nhap thong tin vao text nay");
        webElement.sendKeys(text);
    }
    public void Click(WebElement webElement){
        Assert.assertTrue(webElement.isDisplayed() && webElement.isEnabled(), "Khong the click vao button nay");
        webElement.click();
    }
    @AfterTest
    public void Clear(){
        Sleep(3000);
        chromDriver.quit();
    }
    public void Sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
