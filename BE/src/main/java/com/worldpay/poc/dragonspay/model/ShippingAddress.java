package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "shippingAddress")
public class ShippingAddress {

    private Address address;

    @XmlElement(name = "address")
    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
