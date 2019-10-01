package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "riskData")
public class RiskData {

    private AuthenticationRiskData authenticationRiskData;
    private ShopperAccountRiskData shopperAccountRiskData;
    private TransactionRiskData transactionRiskData;

    @XmlElement(name = "authenticationRiskData")
    public AuthenticationRiskData getAuthenticationRiskData() {
        return authenticationRiskData;
    }

    public void setAuthenticationRiskData(AuthenticationRiskData authenticationRiskData) {
        this.authenticationRiskData = authenticationRiskData;
    }

    @XmlElement(name = "shopperAccountRiskData")
    public ShopperAccountRiskData getShopperAccountRiskData() {
        return shopperAccountRiskData;
    }

    public void setShopperAccountRiskData(ShopperAccountRiskData shopperAccountRiskData) {
        this.shopperAccountRiskData = shopperAccountRiskData;
    }

    @XmlElement(name = "transactionRiskData")
    public TransactionRiskData getTransactionRiskData() {
        return transactionRiskData;
    }

    public void setTransactionRiskData(TransactionRiskData transactionRiskData) {
        this.transactionRiskData = transactionRiskData;
    }
}
