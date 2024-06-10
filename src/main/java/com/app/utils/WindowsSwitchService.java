package com.app.utils;

import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class WindowsSwitchService {

    @Autowired
    private ApplicationContext applicationContext;

    public void switchByTitle(String title) {
        var driver = applicationContext.getBean(WebDriver.class);
        driver.getWindowHandles()
                .stream()
                .filter(handle -> driver.switchTo().window(handle).getTitle().startsWith(title))
                .findFirst()
                .ifPresent(handle -> driver.switchTo().window(handle));
    }

    public void switchByIdx(int idx) {
        var driver = applicationContext.getBean(WebDriver.class);
        var handles = driver.getWindowHandles().toArray(new String[0]);

        if (handles.length < idx) {
            throw new RuntimeException("No such a window");
        }
        driver.switchTo().window(handles[idx]);
    }
}
