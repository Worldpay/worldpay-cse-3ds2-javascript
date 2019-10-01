package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "shopperAccountRiskData")
@XmlType(propOrder = {"transactionsAttemptedLastDay", "transactionsAttemptedLastYear", "purchasesCompletedLastSixMonths",
        "addCardAttemptsLastDay", "previousSuspiciousActivity", "shippingNameMatchesAccountName",
        "shopperAccountCreationDate", "shopperAccountModificationDate", "shopperAccountPasswordChangeDate",
        "shopperAccountShippingAddressFirstUseDate", "shopperAccountPaymentAccountFirstUseDate"})
public class ShopperAccountRiskData {

    private Integer transactionsAttemptedLastDay;
    private Integer transactionsAttemptedLastYear;
    private Integer purchasesCompletedLastSixMonths;
    private Integer addCardAttemptsLastDay;
    private Boolean previousSuspiciousActivity;
    private Boolean shippingNameMatchesAccountName;
    private ShopperAccountCreationDate shopperAccountCreationDate;
    private ShopperAccountModificationDate shopperAccountModificationDate;
    private ShopperAccountPasswordChangeDate shopperAccountPasswordChangeDate;
    private ShopperAccountShippingAddressFirstUseDate shopperAccountShippingAddressFirstUseDate;
    private ShopperAccountPaymentAccountFirstUseDate shopperAccountPaymentAccountFirstUseDate;

    @XmlAttribute(name = "transactionsAttemptedLastDay")
    public Integer getTransactionsAttemptedLastDay() {
        return transactionsAttemptedLastDay;
    }

    public void setTransactionsAttemptedLastDay(Integer transactionsAttemptedLastDay) {
        this.transactionsAttemptedLastDay = transactionsAttemptedLastDay;
    }

    @XmlAttribute(name = "transactionsAttemptedLastYear")
    public Integer getTransactionsAttemptedLastYear() {
        return transactionsAttemptedLastYear;
    }

    public void setTransactionsAttemptedLastYear(Integer transactionsAttemptedLastYear) {
        this.transactionsAttemptedLastYear = transactionsAttemptedLastYear;
    }

    @XmlAttribute(name = "purchasesCompletedLastSixMonths")
    public Integer getPurchasesCompletedLastSixMonths() {
        return purchasesCompletedLastSixMonths;
    }

    public void setPurchasesCompletedLastSixMonths(Integer purchasesCompletedLastSixMonths) {
        this.purchasesCompletedLastSixMonths = purchasesCompletedLastSixMonths;
    }

    @XmlAttribute(name = "addCardAttemptsLastDay")
    public Integer getAddCardAttemptsLastDay() {
        return addCardAttemptsLastDay;
    }

    public void setAddCardAttemptsLastDay(Integer addCardAttemptsLastDay) {
        this.addCardAttemptsLastDay = addCardAttemptsLastDay;
    }

    @XmlAttribute(name = "previousSuspiciousActivity")
    public Boolean getPreviousSuspiciousActivity() {
        return previousSuspiciousActivity;
    }

    public void setPreviousSuspiciousActivity(Boolean previousSuspiciousActivity) {
        this.previousSuspiciousActivity = previousSuspiciousActivity;
    }

    @XmlAttribute(name = "shippingNameMatchesAccountName")
    public Boolean getShippingNameMatchesAccountName() {
        return shippingNameMatchesAccountName;
    }

    public void setShippingNameMatchesAccountName(Boolean shippingNameMatchesAccountName) {
        this.shippingNameMatchesAccountName = shippingNameMatchesAccountName;
    }

    @XmlElement(name = "shopperAccountCreationDate")
    public ShopperAccountCreationDate getShopperAccountCreationDate() {
        return shopperAccountCreationDate;
    }

    public void setShopperAccountCreationDate(ShopperAccountCreationDate shopperAccountCreationDate) {
        this.shopperAccountCreationDate = shopperAccountCreationDate;
    }

    @XmlElement(name = "shopperAccountModificationDate")
    public ShopperAccountModificationDate getShopperAccountModificationDate() {
        return shopperAccountModificationDate;
    }

    public void setShopperAccountModificationDate(ShopperAccountModificationDate shopperAccountModificationDate) {
        this.shopperAccountModificationDate = shopperAccountModificationDate;
    }

    @XmlElement(name = "shopperAccountPasswordChangeDate")
    public ShopperAccountPasswordChangeDate getShopperAccountPasswordChangeDate() {
        return shopperAccountPasswordChangeDate;
    }

    public void setShopperAccountPasswordChangeDate(ShopperAccountPasswordChangeDate shopperAccountPasswordChangeDate) {
        this.shopperAccountPasswordChangeDate = shopperAccountPasswordChangeDate;
    }

    @XmlElement(name = "shopperAccountShippingAddressFirstUseDate")
    public ShopperAccountShippingAddressFirstUseDate getShopperAccountShippingAddressFirstUseDate() {
        return shopperAccountShippingAddressFirstUseDate;
    }

    public void setShopperAccountShippingAddressFirstUseDate(ShopperAccountShippingAddressFirstUseDate shopperAccountShippingAddressFirstUseDate) {
        this.shopperAccountShippingAddressFirstUseDate = shopperAccountShippingAddressFirstUseDate;
    }

    @XmlElement(name = "shopperAccountPaymentAccountFirstUseDate")
    public ShopperAccountPaymentAccountFirstUseDate getShopperAccountPaymentAccountFirstUseDate() {
        return shopperAccountPaymentAccountFirstUseDate;
    }

    public void setShopperAccountPaymentAccountFirstUseDate(ShopperAccountPaymentAccountFirstUseDate shopperAccountPaymentAccountFirstUseDate) {
        this.shopperAccountPaymentAccountFirstUseDate = shopperAccountPaymentAccountFirstUseDate;
    }
}
