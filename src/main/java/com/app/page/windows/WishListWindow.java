package com.app.page.windows;

import com.app.annotation.LazyAutowired;
import com.app.annotation.Window;
import com.app.page.base.BasePage;
import com.app.page.windows.fragments.WishListProductDeletedInfo;
import com.app.utils.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.app.utils.StringUtils.removeSpecialCharsFromString;

@Window("Lista życzeńclassId=WishListWindow")
public class WishListWindow extends BasePage {

    @LazyAutowired
    private WishListProductDeletedInfo wishListProductDeletedInfo;

    @FindBy(xpath = "//h2[text() = 'Moja lista życzeń:']")
    private WebElement wishListTitle;

    @FindBy(xpath = "//td[@class = 'product-name']/a")
    private List<WebElement> productsNamesOnWishList;

    @FindBy(xpath = "//td[@class = 'product-remove']/div/a")
    private List<WebElement> productsRemoveButtons;


    public boolean isSpecificProductOnWishList(String productName) {
        return productsNamesOnWishList.stream().map(WebElement::getText).anyMatch(title -> title.contains(productName));
    }

    public WishListProductDeletedInfo getProductDeletedInfo() {
        return wishListProductDeletedInfo;
    }

    public WishListWindow removeProductFromWishList(String productName) {
        var idxToDelete = getIdxOfProduct(productName);
        productsRemoveButtons.get(idxToDelete).click();
        return this;
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> wishListTitle.isDisplayed());
    }

    private int getIdxOfProduct(String productName) {
        for (int i = 0; i < productsNamesOnWishList.size(); i++) {
            if (removeSpecialCharsFromString(productsNamesOnWishList.get(i).getText()).toLowerCase().contains(removeSpecialCharsFromString(productName.toLowerCase()))) {
                return i;
            }
        }
        return -1;
    }

}
