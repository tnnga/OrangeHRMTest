package com.nnga.pages;

import com.nnga.commons.ValidateHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SearchPage {
    private WebDriver driver;
    private ValidateHelper validateHelper;
    By seaarchInput = By.xpath("//input[@placeholder='Search']");
    By returnText = By.xpath("//body/div[@id='app']/div[1]/div[1]/aside[1]/nav[1]/div[2]/ul[1]/li[1]/a[1]/span[1]");
    public SearchPage(WebDriver driver){
        this.driver = driver;
        validateHelper = new ValidateHelper(driver);
    }
    public void Search(String textInput, String equalValue){
        validateHelper.setText(seaarchInput, textInput);
        boolean vertytifeText = validateHelper.vertifyElementText(returnText, equalValue);
        Assert.assertTrue(vertytifeText);
    }
}
