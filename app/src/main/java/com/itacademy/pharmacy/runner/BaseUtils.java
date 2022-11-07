package com.itacademy.pharmacy.runner;

import io.github.bonigarcia.wdm.WebDriverManager;
import com.itacademy.pharmacy.WebDriver;
import com.itacademy.pharmacy.chrome.ChromeDriver;
import com.itacademy.pharmacy.chrome.ChromeOptions;
import com.itacademy.pharmacy.remote.BrowserType;
import com.itacademy.pharmacy.remote.CapabilityType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class BaseUtils {

    private static ChromeOptions initProperties() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--window-size=1920,1080");
//        options.addArguments("--headless");
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("googlegeolocationaccess.enabled", true);
        prefs.put("profile.default_content_setting_values.geolocation", 2); // 1:allow 2:block
        prefs.put("profile.default_content_setting_values.notifications", 1);
        options.setExperimentalOption("prefs", prefs);
        return options;
    }


    static WebDriver createDriver() {
        WebDriver driver = new ChromeDriver(initProperties());
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }

}