package com.app.page.login_register_form.fragments;

import com.app.SpringBootSeleniumCucumberProj.annotation.PageFragment;
import com.app.SpringBootSeleniumCucumberProj.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@PageFragment
public class RegisterLoginErrorComponent extends BasePage {
    @FindBy(xpath = "//ul[@class='woocommerce-error']/li")
    private List<WebElement> alerts;
    
    public String getErrorMessage() {
        return alerts.stream().filter(WebElement::isDisplayed).findFirst().orElseThrow().getAttribute("innerText");
    }

    public boolean NAlertsAreDisplayed(int n) {
        return n == alerts.size();
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> !alerts.isEmpty());
    }
}
