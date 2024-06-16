package com.app.steps.cart_operations;

import com.app.annotation.LazyAutowired;
import com.app.page.shop.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CartOperationsSteps {
    @LazyAutowired
    private CartPage cartPage;

    @When("I delete added product from the cart {string}")
    public void iDeleteAddedProductFromTheCart(String productName) {
        cartPage.removeSpecificProductFromCart(productName);
    }


    @Then("I will see announcement about empty cart with {string}")
    public void iWillSeeAnnouncementAboutEmptyCartWith(String announcement) {
        Assert.assertTrue(cartPage.isEmptyCartAnnouncementVisible(announcement));
    }

    @And("I will see which product was deleted {string}")
    public void iWillSeeWhichProductWasDeleted(String productName) {
        Assert.assertTrue(cartPage.isDeletedProductAnnouncementVisible(productName));
    }
}
