package com.app.page.shop;


import com.app.annotation.Page;
import com.app.page.base.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

@Page
public class OrderConfirmationPage extends BasePage {

    @FindBy(className = "entry-title")
    private WebElement orderSummaryTitle;
    @FindBy(xpath = "//li[@class = 'woocommerce-order-overview__date date']/strong")
    private WebElement orderDate;

    @FindBy(xpath = "//li[@class = 'woocommerce-order-overview__email email']/strong")
    private WebElement customerEmail;

    @FindBy(xpath = "//li[@class = 'woocommerce-order-overview__total total']/strong")
    private WebElement orderPrice;

    @FindBy(xpath = "//td[@class='woocommerce-table__product-name product-name']/a")
    private List<WebElement> orderedProducts;

    @FindBy(xpath = "//p[@class='woocommerce-customer-details--phone']")
    private WebElement billingPhoneNumber;

    @FindBy(xpath = "//p[@class='woocommerce-customer-details--email']")
    private WebElement billingEmail;

    public boolean areSpecificNumberOfProductsInSummary(int n) {
        return orderedProducts.size() == n;
    }

    public boolean hasSpecificProduct(String productName) {
        return !orderedProducts
                .stream()
                .filter(product -> product.getText().equals(productName))
                .toList()
                .isEmpty();
    }

    public boolean anyProductContainsInName(String partName) {
        return !orderedProducts
                .stream()
                .filter(product -> product.getText().contains(partName))
                .toList()
                .isEmpty();
    }

    public boolean isSpecificEmailInSummary(String email) {
        return billingEmail.getText().equals(email);
    }

    public boolean isSpecificPhoneNumberInSummary(String phoneNumber) {
        return billingPhoneNumber.getText().equals(phoneNumber);
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> orderSummaryTitle.isDisplayed() && !orderedProducts.isEmpty());
    }
}
