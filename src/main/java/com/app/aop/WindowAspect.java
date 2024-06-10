package com.app.aop;

import com.app.annotation.Window;
import com.app.utils.WindowsSwitchService;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class WindowAspect {

    @Autowired
    private WindowsSwitchService windowsSwitchService;

    @Before("@target(window) && within(com.app.SpringBootSeleniumCucumberProj..*)")
    public void before(Window window) {
        windowsSwitchService.switchByTitle(window.value());
    }

    @After("@target(window) && within(com.app.SpringBootSeleniumCucumberProj..*)")
    public void after(Window window) {
        windowsSwitchService.switchByIdx(0);
    }
}
