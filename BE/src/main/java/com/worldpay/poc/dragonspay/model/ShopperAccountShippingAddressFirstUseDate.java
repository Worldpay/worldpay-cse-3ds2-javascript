package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shopperAccountShippingAddressFirstUseDate")
public class ShopperAccountShippingAddressFirstUseDate {

    private Date date;

    @XmlElement(name = "date")
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
