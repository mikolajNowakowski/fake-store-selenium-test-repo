package com.app.page.shop;

import com.app.annotation.Page;
import com.app.page.base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

import static com.app.utils.StringUtils.*;

@Page
public class CartPage extends BasePage {

    @FindBy(xpath = "//img[@class = 'custom-logo']")
    private WebElement logoImg;

    @FindBy(xpath = "//tr[@class = 'woocommerce-cart-form__cart-item cart_item']")
    private List<WebElement> productsInCart;

    @FindBy(xpath = "//div[@class = 'cart-empty woocommerce-info']")
    private WebElement emptyCartAnnouncement;

    @FindBy(xpath = "//div[@class = 'woocommerce-message']")
    private WebElement deletedProductAnnouncement;

    @FindBy(css = ".alt.button.checkout-button.wc-forward")
    private WebElement goToPaymentButton;

    private final String productNameXpath = ".//td[@class = 'product-name']/a";
    private final String productDeleteButtonXpath = ".//td[@class = 'product-remove']/a";

    public boolean isSpecificPositionInCart(String productKeyWord) {
        return productsInCart
                .stream()
                .map(webElement -> removeSpecialCharsFromString(
                        webElement
                                .findElement(By.xpath(productNameXpath))
                                .getText()
                                .toLowerCase()
                ))
                .peek(System.out::println)
                .anyMatch(element -> element
                        .contains(removeSpecialCharsFromString(productKeyWord
                                .toLowerCase()
                                .trim()
                        )));
    }

    public boolean isEmptyCartAnnouncementVisible(String announcement) {
        return wait.until(ExpectedConditions.visibilityOf(emptyCartAnnouncement)).getText().trim().equals(announcement);
    }

    public boolean isDeletedProductAnnouncementVisible(String productName) {
        return removeSpecialCharsFromString(
                        wait.until(ExpectedConditions.visibilityOf(deletedProductAnnouncement))
                        .getText().trim()
                        .toLowerCase())
                .contains(removeSpecialCharsFromString(productName)
                        .trim()
                        .toLowerCase());
    }

    public CartPage removeSpecificProductFromCart(String productName) {
        productsInCart
                .stream()
                .filter(element -> removeSpecialCharsFromString(element.findElement(By.xpath(productNameXpath)).getText()).equalsIgnoreCase(removeSpecialCharsFromString(productName)))
                .findFirst()
                .orElseThrow()
                .findElement(By.xpath(productDeleteButtonXpath))
                .click();
        return this;
    }

    public CartPage goToPayment() {
        goToPaymentButton.click();
        return this;
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> Integer.parseInt(logoImg.getAttribute("width")) > 0);
    }
}
