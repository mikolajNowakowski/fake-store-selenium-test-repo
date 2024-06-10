package com.app.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerOrderForm {
    private String firstName;
    private String lastName;
    private String companyName;
    private String country;
    private String address1;
    private String address2;
    private String postCode;
    private String city;
    private String phoneNumber;
    private String email;
    private boolean createAccount;
    private String additionalComments;
    private boolean termsAcceptation;


}