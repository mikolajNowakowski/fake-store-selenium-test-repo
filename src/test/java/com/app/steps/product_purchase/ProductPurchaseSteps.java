package com.app.steps.product_purchase;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import com.app.SpringBootSeleniumCucumberProj.page.shop.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class ProductPurchaseSteps {


    @LazyAutowired
    private CategoryPage categoryPage;
    @LazyAutowired
    private CartPage cartPage;
    @LazyAutowired
    private CustomerOrderFormPage customerOrderFormPage;
    @LazyAutowired
    private OrderConfirmationPage orderConfirmationPage;


    @And("I add product in specific {string} to cart")
    public void iAddToCart(String sportType) {
        categoryPage
                .addSpecifiedProductToCart(sportType);
    }

    @And("I go to cart")
    public void iGoToCart() {
        categoryPage.goToCart();
    }

    @Then("I will be able to see {string} windsurfing in my cart")
    public void iWillBeAbleToSeeWindsurfingInMyCart(String region) {
        Assert.assertTrue(cartPage.isSpecificPositionInCart(region));
    }

    @When("I proceed with shopping")
    public void iProceedWithShopping() {
        cartPage.goToPayment();
    }

    @Then("I will go to order form")
    public void iWillGoToOrderForm() {
        customerOrderFormPage.isAt();
    }

    @When("I complete customer form")
    public void iCompleteCustomerForm(CustomerOrderForm customerOrderForm) {
        customerOrderFormPage.fillWholeCustomerForm(customerOrderForm);
    }

    @And("I complete payment details")
    public void iCompletePaymentDetails(CreditCard creditCard) {
        customerOrderFormPage.fillPaymentDetails(creditCard);
    }

    @And("Confirm order")
    public void confirmOrder() {
        customerOrderFormPage
                .acceptTerms()
                .submitOrder();
    }

    @Then("I will get confirmation of my order")
    public void iWillGetConfirmationOfMyOrder() {
        orderConfirmationPage.isAt();
    }

    @And("I will see only one ordered product and its details {string}")
    public void iWillSeeOnlyOneOrderedProductAndItsDetails(String region) {
        Assert.assertTrue(orderConfirmationPage.anyProductContainsInName(region));
        Assert.assertTrue(orderConfirmationPage.areSpecificNumberOfProductsInSummary(1));
    }
}
