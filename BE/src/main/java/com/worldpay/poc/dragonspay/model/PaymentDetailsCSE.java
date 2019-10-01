package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"cseData", "session"})
public class PaymentDetailsCSE extends PaymentDetails {

    private CSEData cseData;

    @XmlElement(name = "CSE-DATA")
    public CSEData getCseData() {
        return cseData;
    }

    public void setCseData(CSEData cseData) {
        this.cseData = cseData;
    }
}
