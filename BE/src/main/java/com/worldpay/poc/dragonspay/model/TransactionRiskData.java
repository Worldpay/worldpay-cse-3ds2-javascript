package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transactionRiskData")
public class TransactionRiskData {

    private String shippingMethod;
    private String deliveryTimeframe;
    private String deliveryEmailAddress;
    private Boolean reorderingPreviousPurchases;
    private Boolean preOrderPurchase;
    private Integer giftCardCount;
    private TransactionRiskDataGiftCardAmount transactionRiskDataGiftCardAmount;
    private TransactionRiskDataPreOrderDate transactionRiskDataPreOrderDate;

    @XmlAttribute(name = "shippingMethod")
    public String getShippingMethod() {
        return shippingMethod;
    }

    public void setShippingMethod(String shippingMethod) {
        this.shippingMethod = shippingMethod;
    }

    @XmlAttribute(name = "deliveryTimeframe")
    public String getDeliveryTimeframe() {
        return deliveryTimeframe;
    }

    public void setDeliveryTimeframe(String deliveryTimeframe) {
        this.deliveryTimeframe = deliveryTimeframe;
    }

    @XmlAttribute(name = "deliveryEmailAddress")
    public String getDeliveryEmailAddress() {
        return deliveryEmailAddress;
    }

    public void setDeliveryEmailAddress(String deliveryEmailAddress) {
        this.deliveryEmailAddress = deliveryEmailAddress;
    }

    @XmlAttribute(name = "reorderingPreviousPurchases")
    public Boolean getReorderingPreviousPurchases() {
        return reorderingPreviousPurchases;
    }

    public void setReorderingPreviousPurchases(Boolean reorderingPreviousPurchases) {
        this.reorderingPreviousPurchases = reorderingPreviousPurchases;
    }

    @XmlAttribute(name = "preOrderPurchase")
    public Boolean getPreOrderPurchase() {
        return preOrderPurchase;
    }

    public void setPreOrderPurchase(Boolean preOrderPurchase) {
        this.preOrderPurchase = preOrderPurchase;
    }

    @XmlAttribute(name = "giftCardCount")
    public Integer getGiftCardCount() {
        return giftCardCount;
    }

    public void setGiftCardCount(Integer giftCardCount) {
        this.giftCardCount = giftCardCount;
    }

    @XmlElement(name = "transactionRiskDataGiftCardAmount")
    public TransactionRiskDataGiftCardAmount getTransactionRiskDataGiftCardAmount() {
        return transactionRiskDataGiftCardAmount;
    }

    public void setTransactionRiskDataGiftCardAmount(TransactionRiskDataGiftCardAmount transactionRiskDataGiftCardAmount) {
        this.transactionRiskDataGiftCardAmount = transactionRiskDataGiftCardAmount;
    }

    @XmlElement(name = "transactionRiskDataPreOrderDate")
    public TransactionRiskDataPreOrderDate getTransactionRiskDataPreOrderDate() {
        return transactionRiskDataPreOrderDate;
    }

    public void setTransactionRiskDataPreOrderDate(TransactionRiskDataPreOrderDate transactionRiskDataPreOrderDate) {
        this.transactionRiskDataPreOrderDate = transactionRiskDataPreOrderDate;
    }
}
