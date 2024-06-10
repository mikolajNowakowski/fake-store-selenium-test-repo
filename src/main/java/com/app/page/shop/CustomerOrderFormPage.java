package com.app.page.shop;

import com.app.SpringBootSeleniumCucumberProj.annotation.LazyAutowired;
import com.app.SpringBootSeleniumCucumberProj.annotation.Page;
import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import com.app.SpringBootSeleniumCucumberProj.page.base.BasePage;
import com.app.SpringBootSeleniumCucumberProj.utils.SeleniumHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

@Page
public class CustomerOrderFormPage extends BasePage {
    @FindBy(xpath = "//img[@class = 'custom-logo']")
    private WebElement logoImg;

    @FindBy(name = "billing_first_name")
    private WebElement firstName;

    @FindBy(name = "billing_last_name")
    private WebElement lastName;

    @FindBy(name = "billing_company")
    private WebElement companyName;

    @FindBy(id = "billing_country")
    private WebElement country;

    @FindBy(name = "billing_address_1")
    private WebElement address;

    @FindBy(id = "billing_address_2")
    private WebElement addressOptional;

    @FindBy(id = "billing_postcode")
    private WebElement postCode;

    @FindBy(id = "billing_city")
    private WebElement city;

    @FindBy(id = "billing_phone")
    private WebElement phone;

    @FindBy(id = "billing_email")
    private WebElement mail;

    @FindBy(id = "createaccount")
    private WebElement createAccountCheckbox;

    @FindBy(id = "order_comments")
    private WebElement additionalComments;

    @FindBy(name = "cardnumber")
    private WebElement cardNumber;

    @FindBy(name = "exp-date")
    private WebElement cardExpirationDay;

    @FindBy(name = "cvc")
    private WebElement cardCvcNumber;

    @FindBy(name = "terms")
    private WebElement termsAcceptation;

    @FindBy(id = "place_order")
    private WebElement submitOrderButton;

    @FindBy(xpath = "//iframe[contains(@name,'__privateStripeFrame')]")
    private List<WebElement> cardDetailsIframes;

    @LazyAutowired
    private SeleniumHelper seleniumHelper;


    public CustomerOrderFormPage fillWholeCustomerForm(CustomerOrderForm customer) {
        sendKeysIfNotNull(firstName, customer.getFirstName());
        sendKeysIfNotNull(lastName, customer.getLastName());
        sendKeysIfNotNull(companyName, customer.getCompanyName());
        sendKeysIfNotNull(address, customer.getAddress1());
        sendKeysIfNotNull(addressOptional, customer.getAddress2());
        sendKeysIfNotNull(postCode, customer.getPostCode());
        sendKeysIfNotNull(city, customer.getCity());
        sendKeysIfNotNull(phone, customer.getPhoneNumber());
        sendKeysIfNotNull(mail, customer.getEmail());
        selectByVisibleText(country, customer.getCountry());
        sendKeysIfNotNull(additionalComments, customer.getAdditionalComments());
        checkCheckBoxIfTrue(createAccountCheckbox, customer.isCreateAccount());
        return this;
    }

    public CustomerOrderFormPage fillPaymentDetails(CreditCard creditCard) {

        if (cardDetailsIframes.size() != 3) {
            throw new IllegalStateException("Wrong number of iframes in card details section.");
        }

        sendKeysInAnotherFrame(cardNumber, creditCard.getCardNumber(), cardDetailsIframes.get(0).getAttribute("name"));
        sendKeysInAnotherFrame(cardExpirationDay, creditCard.getCardExpirationDate(), cardDetailsIframes.get(1).getAttribute("name"));
        sendKeysInAnotherFrame(cardCvcNumber, creditCard.getCvcNumber(), cardDetailsIframes.get(2).getAttribute("name"));
        return this;
    }

    public void sendKeysInAnotherFrame(WebElement element, String message, String iframeName) {
        driver.switchTo().frame(iframeName);
        sendKeysIfNotNull(element, message);
        driver.switchTo().defaultContent();
    }

    public CustomerOrderFormPage acceptTerms() {
        seleniumHelper.scrollToElement(termsAcceptation);
        termsAcceptation.click();
        return this;
    }


    public CustomerOrderFormPage submitOrder() {
        seleniumHelper.scrollToElement(submitOrderButton);
        submitOrderButton.click();
        return this;
    }


    private void selectByVisibleText(WebElement element, String text) {
        var select = new Select(element);
        select.selectByVisibleText(text);
    }

    private void checkCheckBoxIfTrue(WebElement webElement, boolean value) {
        if (!value) {
            return;
        }
        webElement.click();
    }


    private void sendKeysIfNotNull(WebElement element, String message) {
        if (message == null) {
            return;
        }
        element.sendKeys(message);
    }


    @Override
    public boolean isAt() {
        return wait.until((d) -> Integer.parseInt(logoImg.getAttribute("width")) > 0);
    }
}
