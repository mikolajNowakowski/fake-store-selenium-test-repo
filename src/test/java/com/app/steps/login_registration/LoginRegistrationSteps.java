package com.app.steps.login_registration;

import com.app.annotation.LazyAutowired;
import com.app.page.MyAccountPage;
import com.app.page.StoreHomePage;
import com.app.page.login_register_form.LoginFormPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginRegistrationSteps {
    @LazyAutowired
    private LoginFormPage loginFormPage;
    @LazyAutowired
    private MyAccountPage myAccountPage;
    @LazyAutowired
    private StoreHomePage storeHomePage;



    @Then("I am on the login form page")
    public void isAtLoginForm() {
        loginFormPage.isAt();
    }

    @When("I provide {string} and {string} to register")
    public void provideCredentials(String email, String password) {
        loginFormPage.registerUser(email, password);
    }

    @Then("I am successfully logged in to my account {string}")
    public void isLoggedOnSpecifiedAccount(String email) {
        myAccountPage.isAt();
        var userName = email.split("@")[0];
        Assert.assertTrue(myAccountPage.hasSpecifiedName(userName));
    }

    @When("I log out from my account")
    public void logOut() {
        myAccountPage.logOut();
    }

    @When("I log in with the same {string} and {string}")
    public void logInWithSpecifiedCredentials(String email, String password) {
        loginFormPage.isAt();
        loginFormPage.logIn(email, password);
    }

    @And("I see only one error message")
    public void iSeeOnlyOneErrorMessage() {
        loginFormPage.getErrorComponent().NAlertsAreDisplayed(1);
    }

    @Then("I get specified error message {string}")
    public void iGetSpecifiedErrorMessage(String arg0) {
        Assert.assertEquals(loginFormPage.getErrorComponent().getErrorMessage(), arg0);
    }
}


