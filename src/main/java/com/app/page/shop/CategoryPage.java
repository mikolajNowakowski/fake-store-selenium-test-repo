package com.app.page.shop;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.annotation.Page;
import com.app.SpringBootSeleniumCucumberProj.page.base.BasePage;
import com.app.SpringBootSeleniumCucumberProj.utils.SeleniumHelper;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Objects;

@Page
public class CategoryPage extends BasePage {

    @FindBy(xpath = "//li[contains(@class,'product type-product')]")
    private List<WebElement> products;
    @FindBy(xpath = "//a[@class = 'cart-contents']")
    private WebElement cartButton;

    @FindBy(xpath = "//a[@class = 'cart-contents']//span[@class = 'count']")
    private WebElement numberOfProductsInCart;

    @FindBy(xpath = "//h2[@class='woocommerce-loop-product__title']")
    private List<WebElement> productsTitles;

    @LazyAutowired
    private SeleniumHelper seleniumHelper;

    private final String titleOFProductLocator = "//h2[contains(text(),%s)]";
    private final String addToCartButtonLinkedText = "Dodaj do koszyka";


    public CategoryPage addSpecifiedProductToCart(String keyWord) {
        var product = products.stream().filter(webElement -> !webElement.findElements(By.xpath(titleOFProductLocator.formatted(keyWord))).isEmpty());
        product.findFirst().orElseThrow().findElement(By.linkText(addToCartButtonLinkedText)).click();

        wait.until((d) -> !Objects.equals(numberOfProductsInCart.getText(), ""));
        return this;
    }

    public CategoryPage goToCart() {
        cartButton.click();
        return this;
    }

    public CategoryPage openSpecificProduct(String productName) {
        var product = productsTitles
                .stream()
                .filter(element -> element
                        .getText()
                        .equals(productName))
                .findFirst().orElseThrow();

        seleniumHelper.scrollToElement(product);

        product.click();

        return this;
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> !products.isEmpty());
    }
}
