package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "transactionRiskDataGiftCardAmount")
public class TransactionRiskDataGiftCardAmount {

    private Amount amount;

    @XmlElement(name = "amount")
    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }
}
