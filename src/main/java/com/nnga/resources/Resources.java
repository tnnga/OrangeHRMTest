package com.nnga.resources;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class Resources {
    private WebDriver driver;
    private WebDriverWait wait;
    private final Duration timeoutWaitForPageLoaded = Duration.ofSeconds(20);
    JavascriptExecutor js;

    public Resources(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    public void setText(By element, String value) {
        waitForPageLoaded();
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).clear();
        driver.findElement(element).sendKeys(value);
    }
    public String getText(By element){
        waitForPageLoaded();
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText();
    }
    public void clickElement(By element) {
        waitForPageLoaded();
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        driver.findElement(element).click();
    }
    public void clickElementByJS(By element){
        waitForPageLoaded();
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        js.executeScript("arguments[0].click();", driver.findElement(element));
    }

    public void waitForPageLoaded() {
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
                        .equals("complete");
            }
        };
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeoutWaitForPageLoaded);
            wait.until(expectation);
        } catch (Throwable error) {
            Assert.fail("Timeout waiting for Page Load Request to complete.");
        }
    }

    public boolean vertifyUrl(String url) {
        waitForPageLoaded();
        System.out.println(driver.getCurrentUrl());
        System.out.println(url);

        return driver.getCurrentUrl().contains(url);
    }

    public boolean vertifyElementText(By element, String textValue) {
        waitForPageLoaded();
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
        return driver.findElement(element).getText().equals(textValue);
    }
    public boolean elementIsDisplay(By element){
        waitForPageLoaded();
        if(wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed()){
            return true;
        }
        return false;
    }
}
