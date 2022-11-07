package com.itacademy.pharmacy.runner;

import com.itacademy.pharmacy.model.StartPage;
import com.itacademy.pharmacy.WebDriver;
import com.itacademy.pharmacy.interactions.Actions;
import com.itacademy.pharmacy.support.ui.WebDriverWait;
import com.itacademy.pharmacy.annotations.*;

public abstract class BaseTest {

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

    @BeforeMethod
    protected void beforeMethod() {
        driver = BaseUtils.createDriver();
        getWeb();
    }

    @AfterMethod
    protected void afterMethod() {
        driver.quit();
    }
    @BeforeClass(groups = {"l"})
    protected void beforeMethodL() {
        driver = BaseUtils.createDriver();
        getWeb();
    }

    @AfterClass(groups = {"l"})
    protected void afterMethodL() {
        driver.quit();
    }

    public StartPage getWeb() {
        getDriver().get("https://anc.ua/");
        return new StartPage(getDriver());
    }




}