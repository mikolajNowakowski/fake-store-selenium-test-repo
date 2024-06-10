package com.app.page;

import com.app.annotation.Page;
import com.app.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Value;

@Page
public class StoreHomePage extends BasePage {
    @FindBy(css = ".custom-logo-link > img[alt='FakeStore']")
    private WebElement storeLogo;



    @FindBy(id = "menu-item-200")
    private WebElement cartButton;





    @Value("${store.url}")
    private String url;

    public void goTo() {
        driver.get(url);
    }





    @Override
    public boolean isAt() {
        return wait.until((d) -> Integer.parseInt(storeLogo.getAttribute("height")) > 0);
    }
}
