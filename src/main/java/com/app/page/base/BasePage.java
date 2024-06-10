package com.app.page.base;

import jakarta.annotation.PostConstruct;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class BasePage {

    @Autowired
    protected WebDriver driver;

    @Autowired
    protected WebDriverWait wait;

    @FindBy(id = "menu-item-248")
    private WebElement mainBarWishListButton;

    @FindBy(id = "menu-item-198")
    private WebElement mainBarShopButton;

    @FindBy(id = "menu-item-201")
    private WebElement mainBarMyAccountButton;

    public BasePage goToLoginForm() {
        mainBarMyAccountButton.click();
        return this;
    }

    public BasePage goToShop() {
        mainBarShopButton.click();
        return this;
    }

    public BasePage goToWishList() {
        mainBarWishListButton.click();
        return this;
    }

    @PostConstruct
    private void init() {
        PageFactory.initElements(driver, this);
    }

    public abstract boolean isAt();
}
