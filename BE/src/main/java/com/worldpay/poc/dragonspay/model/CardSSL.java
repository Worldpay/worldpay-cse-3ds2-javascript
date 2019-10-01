package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CARD-SSL")
@XmlType(propOrder = {"cardNumber", "expiryDate", "cardHolderName", "cvc", "cardAddress"})
public class CardSSL {

    private String cardNumber;

    private ExpiryDate expiryDate;

    private String cardHolderName;

    private Integer cvc;

    private CardAddress cardAddress;

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @XmlElement(name = "expiryDate")
    public ExpiryDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(ExpiryDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    @XmlElement(name = "cardAddress")
    public CardAddress getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(CardAddress cardAddress) {
        this.cardAddress = cardAddress;
    }
}
