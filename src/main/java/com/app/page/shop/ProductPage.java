package com.app.page.shop;

import com.app.SpringBootSeleniumCucumberProj.annotation.Page;
import com.app.SpringBootSeleniumCucumberProj.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

@Page
public class ProductPage extends BasePage {
    @FindBy(xpath = "//h1[@class = 'product_title entry-title']")
    private WebElement productTitle;

    @FindBy(xpath = "//div[@class = 'yith-wcwl-add-button']/a[@class = 'add_to_wishlist single_add_to_wishlist']")
    private WebElement addToWishListButton;

    public ProductPage addToWishList() {
        addToWishListButton.click();
        return this;
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> productTitle.isDisplayed());
    }
}
