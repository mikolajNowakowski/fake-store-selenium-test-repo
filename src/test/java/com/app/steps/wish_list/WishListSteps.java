package com.app.steps.wish_list;

import com.app.annotation.LazyAutowired;
import com.app.page.shop.CategoryPage;
import com.app.page.shop.ProductPage;
import com.app.page.windows.WishListWindow;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


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

    @When("I remove {string} from wish list")
    public void iRemoveFromWishList(String productName) {
        wishListWindow.removeProductFromWishList(productName);
    }

    @Then("I will be able to see {string} about deleted product")
    public void iWillBeAbleToSeeAboutDeletedProduct(String message) {
        Assert.assertTrue(wishListWindow.getProductDeletedInfo().doesInfoContains(message));
    }
}
