package com.app.steps.wish_list;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.page.shop.CategoryPage;
import com.app.SpringBootSeleniumCucumberProj.page.shop.ProductPage;
import com.app.SpringBootSeleniumCucumberProj.page.windows.WishListWindow;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class WishListSteps {

    @LazyAutowired
    private CategoryPage categoryPage;
    @LazyAutowired
    private ProductPage productPage;
    @LazyAutowired
    private WishListWindow wishListWindow;

    @And("I open specific {string}")
    public void iOpenSpecific(String product) {
        categoryPage.openSpecificProduct(product);
    }

    @Then("I will be on product page")
    public void iWillBeOnProductPage() {
        productPage.isAt();
    }


    @When("I add product to wish list")
    public void iAddProductToWishList() {
        productPage.addToWishList();
    }


    @And("I go to the wish list")
    public void iGoToTheWishList() {
        productPage.goToWishList();
    }

    @Then("I will be able to see added {string}")
    public void iWillBeAbleToSeeAdded(String product) {
        wishListWindow.isSpecificProductOnWishList(product);
    }
}
