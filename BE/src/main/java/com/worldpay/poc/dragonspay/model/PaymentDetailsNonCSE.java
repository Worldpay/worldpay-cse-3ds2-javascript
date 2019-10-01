package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"cardSSL", "session"})
public class PaymentDetailsNonCSE extends PaymentDetails {

    private CardSSL cardSSL;

    @XmlElement(name = "CARD-SSL")
    public CardSSL getCardSSL() {
        return cardSSL;
    }

    public void setCardSSL(CardSSL cardSSL) {
        this.cardSSL = cardSSL;
    }
}
