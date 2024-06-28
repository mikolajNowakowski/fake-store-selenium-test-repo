package com.app.page.shop;

import com.app.annotation.Page;
import com.app.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@Page
public class ProductPage extends BasePage {
    @FindBy(xpath = "//h1[@class = 'product_title entry-title']")
    private WebElement productTitle;

    @FindBy(xpath = "//div[@class = 'yith-wcwl-add-button']/a[@class = 'add_to_wishlist single_add_to_wishlist']")
    private WebElement addToWishListButton;
    @FindBy(xpath = "//span[@class = 'feedback']")
    private WebElement elementAddedToWishListConfirmation;

    public ProductPage addToWishList() {
        addToWishListButton.click();
        wait.until(ExpectedConditions.visibilityOf(elementAddedToWishListConfirmation));
        return this;
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> productTitle.isDisplayed());
    }
}
