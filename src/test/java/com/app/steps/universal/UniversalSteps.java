package com.app.steps.universal;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.page.StoreHomePage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.ShopPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class UniversalSteps {

    @LazyAutowired
    private StoreHomePage storeHomePage;
    @LazyAutowired
    private ShopPage shopPage;

    @Given("I am on the store home page")
    public void goToHomePage() {
        storeHomePage.goTo();
    }

    @When("I click on the MyAccount button")
    public void goToStore() {
        storeHomePage.goToLoginForm();
    }

    @When("I click store button")
    public void iClickStoreButton() {
        storeHomePage.goToShop();
    }

    @And("I click on {string}")
    public void iClickOn(String category) {
        shopPage
                .clickOnSpecificCategory(category);
    }


}
