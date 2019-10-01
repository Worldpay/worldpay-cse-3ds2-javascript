package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "session")
public class Session {

    private String shopperIPAddress;

    private String id;

    @XmlAttribute
    public String getShopperIPAddress() {
        return shopperIPAddress;
    }

    public void setShopperIPAddress(String shopperIPAddress) {
        this.shopperIPAddress = shopperIPAddress;
    }

    @XmlAttribute
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
