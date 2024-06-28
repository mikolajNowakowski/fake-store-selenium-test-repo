package com.app.aop;

import com.app.annotation.Window;
import com.app.annotation.WindowFragment;
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

    @Before("@target(window) && within(com.app..*)")
    public void before(Window window) {

        System.out.println((removeClassId(window.value())));
        windowsSwitchService.switchByTitle(removeClassId(window.value()));
    }

    @After("@target(window) && within(com.app..*)")
    public void after(Window window) {
        windowsSwitchService.switchByIdx(0);
    }

    @Before("@target(windowFragment) && within(com.app..*)")
    public void before(WindowFragment windowFragment) {
        System.out.println((removeClassId(windowFragment.value())));
        windowsSwitchService.switchByTitle(removeClassId(windowFragment.value()));
    }

    @After("@target(windowFragment) && within(com.app..*)")
    public void after(WindowFragment windowFragment) {
        windowsSwitchService.switchByIdx(0);
    }

    private String removeClassId(String title){
        if (title == null || title.isEmpty()) {
            return title;
        }
        int index = title.indexOf("classId");
        if (index == -1) {
            return title;
        }
        return title.substring(0, index);
    }
}
