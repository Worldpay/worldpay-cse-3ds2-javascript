package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "CSE-DATA")
@XmlType(propOrder = {"encryptedData", "cardAddress"})
public class CSEData {

    private String encryptedData;
    private CardAddress cardAddress;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    @XmlElement(name = "cardAddress")
    public CardAddress getCardAddress() {
        return cardAddress;
    }

    public void setCardAddress(CardAddress cardAddress) {
        this.cardAddress = cardAddress;
    }
}
