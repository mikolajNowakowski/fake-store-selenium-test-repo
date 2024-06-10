package com.app.steps.hooks;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import io.cucumber.java.After;
import org.openqa.selenium.WebDriver;

public class CucumberHooks {
    @LazyAutowired
    private WebDriver driver;

    @After
    public void teardown() {
        driver.quit();
    }
}
