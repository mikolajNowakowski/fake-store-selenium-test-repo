package com.app.utils;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class SeleniumHelper {

    @LazyAutowired
    AnnotationConfigApplicationContext context;

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) context.getBean(WebDriver.class)).executeScript("arguments[0].scrollIntoView(true);", element);
    }


}