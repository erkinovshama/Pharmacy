package com.itacademy.pharmacy.tests;


import com.itacademy.pharmacy.model.StartPage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.itacademy.pharmacy.runner.BaseTest;

public class StartTest extends BaseTest {
    private String medicine = "";

    public StartTest(String a) {
        this.medicine = a;
    }

    @Test(groups = {"l"})
    public void testBuyMedicine() {
        new StartPage(getDriver())
                .inputSearch(medicine)
                .clickSearch()
                .clickMedicine(medicine)
                .clickBuy()
                .clickInBasket();
//        Assert.assertTrue();
    }

    @Test(groups = {"l"}, dependsOnMethods = "testBuyMedicine")
    public void test() {
        String actualResult = new StartPage(getDriver())
                .clickBasket()
                .clickDelete(medicine)
                .getTextBasketEmpty();

        Assert.assertEquals(actualResult, "Ваш кошик покупок пустий");
    }
}