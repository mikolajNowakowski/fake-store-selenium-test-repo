package com.app.steps.cart_operations;

import com.app.annotation.LazyAutowired;
import com.app.page.shop.CartPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartOperationsSteps {


    @LazyAutowired
    private CartPage cartPage;


    @When("I delete added product from the cart {string}")
    public void iDeleteAddedProductFromTheCart(String productName) {

        cartPage.removeSpecificProductFromCart(productName);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("I will see announcement about empty cart")
    public void iWillSeeAnnouncementAboutEmptyCart() {

    }

    @And("I will see which product was deleted {string}")
    public void iWillSeeWhichProductWasDeleted(String productName) {

    }


}
