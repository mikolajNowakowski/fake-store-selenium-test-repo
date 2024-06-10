package com.app.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreditCard {
    private String cardNumber;
    private String cardExpirationDate;
    private String cvcNumber;
}
