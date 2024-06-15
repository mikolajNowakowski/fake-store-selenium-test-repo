package com.app;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@CucumberOptions(
        features = "./src/test/resources/features",
        plugin = {"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:","pretty"},
        glue = "com.app.steps",
        tags = "@productRemovalFromCart",
        monochrome = true)
@RunWith(Cucumber.class)
public class CucumberRunnerTest {


}
