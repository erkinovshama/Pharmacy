package com.itacademy.pharmacy.model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import com.itacademy.pharmacy.runner.BaseModel;

public class PromotionsPage extends BaseModel {
    @FindBy(xpath = "//h2")
    private WebElement h2;

    public PromotionsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageText(){

        return getWait20().until(ExpectedConditions.visibilityOf(h2)).getText();
    }
}