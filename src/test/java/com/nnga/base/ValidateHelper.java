package com.nnga.base;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class ValidateHelper {
    private WebDriver driver;
    private WebDriverWait wait;
    private final Duration timeoutWaitForPageLoaded = Duration.ofSeconds(20);
    JavascriptExecutor js;
    public ValidateHelper(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }
    public void setText(By element, String value){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }
    public void clickElement(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
        //js.executeScript("arguments[0].click();", driver.findElement(element));
    }
    public void waitForPageLoaded(){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            @Override
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState")
                        .toString().equals("complete");
            }
        };
        try{
            WebDriverWait wait = new WebDriverWait(driver, timeoutWaitForPageLoaded);
            wait.until(expectation);
        } catch (Throwable error){
            Assert.fail("Timeout waiting for page load request.");
        }
    }
    public boolean vertifyUrl(String url){
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);

        return driver.getCurrentUrl().contains(url);
    }
    public void Sleep(int time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
