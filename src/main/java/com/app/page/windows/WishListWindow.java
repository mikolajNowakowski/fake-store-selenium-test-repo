package com.app.page.windows;

import com.app.annotation.Window;
import com.app.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Window("Lista życzeń")
public class WishListWindow extends BasePage {


    @FindBy(xpath = "//h2[text() = 'Moja lista życzeń:']")
    private WebElement wishListTitle;

    @FindBy(xpath = "//td[@class = 'product-name']/a")
    private List<WebElement> productsOnWishList;

    public boolean isSpecificProductOnWishList(String productName) {
        return productsOnWishList.stream().map(WebElement::getText).anyMatch(title -> title.contains(productName));
    }


    @Override
    public boolean isAt() {
        return wait.until((d) -> wishListTitle.isDisplayed());
    }
}
