package com.app.steps.mappers;

import com.app.SpringBootSeleniumCucumberProj.model.CreditCard;
import com.app.SpringBootSeleniumCucumberProj.model.CustomerOrderForm;
import io.cucumber.java.DataTableType;

import java.util.Map;

public class CustomerOrderFormMapper {

    @DataTableType
    public CustomerOrderForm customerEntry(Map<String, String> entry) {
        return CustomerOrderForm.builder()
                .firstName(entry.get("firstName"))
                .lastName(entry.get("lastName"))
                .companyName(entry.get("companyName"))
                .country(entry.get("country"))
                .address1(entry.get("address1"))
                .address2(entry.get("address2"))
                .postCode(entry.get("postCode"))
                .city(entry.get("city"))
                .phoneNumber(entry.get("phoneNumber"))
                .email(entry.get("email"))
                .createAccount(Boolean.parseBoolean(entry.get("createAccount")))
                .additionalComments(entry.get("additionalComments"))
                .termsAcceptation(Boolean.parseBoolean(entry.get("termsAcceptation")))
                .build();
    }

    @DataTableType
    public CreditCard creditEntry(Map<String, String> entry) {
        return CreditCard.builder()
                .cardNumber(entry.get("cardNumber"))
                .cardExpirationDate(entry.get("cardExpirationDate"))
                .cvcNumber(entry.get("cvcNumber"))
                .build();
    }
}
