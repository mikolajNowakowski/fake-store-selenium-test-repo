package com.app.page;

import com.app.annotation.Page;
import com.app.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class MyAccountPage extends BasePage {
    @FindBy(css = ".custom-logo-link > img[alt='FakeStore']")
    private WebElement storeLogo;

    @FindBy(css = ".woocommerce-MyAccount-navigation-link.woocommerce-MyAccount-navigation-link--customer-logout > a")
    private WebElement logOutButton;

    @FindBy(css = ".woocommerce-MyAccount-content p:nth-of-type(1) > strong:nth-of-type(1)")
    private WebElement loggedUserName;

    public MyAccountPage logOut() {
        logOutButton.click();
        return this;
    }
    public boolean hasSpecifiedName(String userName) {
        return userName.equals(loggedUserName.getAttribute("innerText"));
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> Integer.parseInt(storeLogo.getAttribute("height")) > 0 && loggedUserName.isDisplayed());
    }
}
