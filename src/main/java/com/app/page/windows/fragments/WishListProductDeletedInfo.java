package com.app.page.windows.fragments;


import com.app.annotation.Window;
import com.app.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


@Window("Lista życzeńclassId=WishListProductDeletedInfo")
public class WishListProductDeletedInfo extends BasePage {
    @FindBy(xpath = "//div[@class = 'woocommerce-message']")
    private WebElement productDeletedInfo;

    public boolean doesInfoContains(String infoMessage) {
        return productDeletedInfo
                .getText()
                .contains(infoMessage);
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> productDeletedInfo.isDisplayed());
    }
}
