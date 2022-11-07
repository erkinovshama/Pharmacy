package com.itacademy.pharmacy.model;

import com.itacademy.pharmacy.WebDriver;
import com.itacademy.pharmacy.runner.BaseModel;

public class BasePage extends BaseModel {


    public BasePage(WebDriver driver) {
        super(driver);
    }

    public StartPage goHome() {
        getDriver().get("https://anc.ua/");
        return new StartPage(getDriver());
    }
}