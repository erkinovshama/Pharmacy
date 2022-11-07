package com.itacademy.pharmacy.runner;

import com.itacademy.pharmacy.WebDriver;
import com.itacademy.pharmacy.interactions.Actions;
import com.itacademy.pharmacy.support.PageFactory;
import com.itacademy.pharmacy.support.ui.WebDriverWait;

public class BaseModel {
    protected WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;


    protected WebDriver getDriver() {
        return driver;
    }

    protected WebDriverWait getWait20() {
        if (wait == null) {
            wait = new WebDriverWait(getDriver(), 20);
        }

        return wait;
    }

    protected Actions getActions() {
        if(actions == null) {
            actions = new Actions(driver);
        }

        return actions;
    }
    public BaseModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(getDriver(), this);
    }



}