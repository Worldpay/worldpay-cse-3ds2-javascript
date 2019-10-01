package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "order")
@XmlType(propOrder = {"description", "amount", "orderContent", "paymentDetails", "shopper",
        "shippingAddress", "riskData", "additional3DSData"})
public class Order {

    private String orderCode;

    private String description;

    private Amount amount;

    private PaymentDetails paymentDetails;

    private Shopper shopper;

    private DDCData additional3DSData;

    private String orderContent;

    private ShippingAddress shippingAddress;

    private RiskData riskData;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @XmlElement(name = "amount")
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    @XmlAttribute
    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getOrderContent() {
        return orderContent;
    }

    public void setOrderContent(String orderContent) {
        this.orderContent = orderContent;
    }

    @XmlElements({
            @XmlElement(name = "paymentDetails", type = PaymentDetailsCSE.class),
            @XmlElement(name = "paymentDetails", type = PaymentDetailsNonCSE.class)
    })
    public PaymentDetails getPaymentDetails() {
        return paymentDetails;
    }

    public void setPaymentDetails(PaymentDetails paymentDetails) {
        this.paymentDetails = paymentDetails;
    }

    @XmlElement(name = "shopper")
    public Shopper getShopper() {
        return shopper;
    }

    public void setShopper(Shopper shopper) {
        this.shopper = shopper;
    }

    @XmlElement(name = "additional3DSData")
    public DDCData getAdditional3DSData() {
        return additional3DSData;
    }

    public void setAdditional3DSData(DDCData additional3DSData) {
        this.additional3DSData = additional3DSData;
    }

    @XmlElement(name = "shippingAddress")
    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    @XmlElement(name = "riskData")
    public RiskData getRiskData() {
        return riskData;
    }

    public void setRiskData(RiskData riskData) {
        this.riskData = riskData;
    }
}
