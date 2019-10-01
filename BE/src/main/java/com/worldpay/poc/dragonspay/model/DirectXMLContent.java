package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "paymentService")
public class DirectXMLContent {

    private double version;

    private String merchantCode;

    private PaymentContent submit;

    @XmlAttribute
    public double getVersion() {
        return version;
    }

    public void setVersion(double version) {
        this.version = version;
    }

    @XmlAttribute
    public String getMerchantCode() {
        return merchantCode;
    }

    public void setMerchantCode(String merchantCode) {
        this.merchantCode = merchantCode;
    }

    @XmlElement(name = "submit")
    public PaymentContent getSubmit() {
        return submit;
    }

    public void setSubmit(PaymentContent submit) {
        this.submit = submit;
    }
}
