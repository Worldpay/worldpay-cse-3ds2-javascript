package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "expiryDate")
public class ExpiryDate {

    private ExpiryDateDetails expiryDateDetails;

    @XmlElement(name = "date")
    public ExpiryDateDetails getExpiryDateDetails() {
        return expiryDateDetails;
    }

    public void setExpiryDateDetails(ExpiryDateDetails expiryDateDetails) {
        this.expiryDateDetails = expiryDateDetails;
    }
}
