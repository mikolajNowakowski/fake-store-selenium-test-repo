package com.app.page.login_register_form;


import com.app.annotation.Page;
import com.app.page.base.BasePage;
import com.app.page.login_register_form.fragments.RegisterLoginErrorComponent;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;


@Page
public class LoginFormPage extends BasePage {
    @Autowired
    RegisterLoginErrorComponent registerLoginErrorComponent;

    @FindBy(id = "reg_email")
    private WebElement registrationEmail;

    @FindBy(id = "reg_password")
    private WebElement registrationPassword;

    @FindBy(name = "register")
    private WebElement registerSubmit;

    @FindBy(id = "username")
    private WebElement loginUsername;

    @FindBy(id = "password")
    private WebElement loginPassword;

    @FindBy(name = "login")
    private WebElement submitLogin;

    @FindBy(id = "rememberme")
    private WebElement rememberMeCheckbox;

    public RegisterLoginErrorComponent getErrorComponent(){
        return registerLoginErrorComponent;
    }

    public LoginFormPage registerUser(String email, String password) {
        provideRegisterEmail(email);
        provideRegisterPassword(password);
        submitRegistration();
        return this;
    }

    public LoginFormPage logIn(String email, String password) {
        provideLogin(email);
        providePassword(password);
        logIn();
        return this;
    }

    // ================== login form =======================
    public LoginFormPage provideLogin(String email) {
        loginUsername.sendKeys(email);
        return this;
    }

    public LoginFormPage providePassword(String password) {
        loginPassword.sendKeys(password);
        return this;
    }

    public LoginFormPage logIn() {
        submitLogin.click();
        return this;
    }
    // ================== registration form =======================
    public LoginFormPage provideRegisterEmail(String email) {
        registrationEmail.sendKeys(email);
        return this;
    }

    public LoginFormPage provideRegisterPassword(String password) {
        registrationPassword.sendKeys(password);
        return this;
    }

    public LoginFormPage submitRegistration() {
        registerSubmit.click();
        return this;
    }

    @Override
    public boolean isAt() {
        return wait.until((d) -> registerSubmit.isDisplayed() && submitLogin.isDisplayed());
    }
}
