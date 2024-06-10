package com.app;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = "./src/test/resources/features",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty"},
        glue = "com.app.SpringBootSeleniumCucumberProj.steps",
        tags = "@addingProductToWishList or @productPurchase",
        monochrome = true)
@RunWith(Cucumber.class)
public class CucumberRunnerTest {


}
