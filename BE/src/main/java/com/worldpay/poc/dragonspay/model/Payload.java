package com.worldpay.poc.dragonspay.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Payload {

    @JsonProperty("encrypted-data")
    private String encryptedData;
    private String cardHolderName;
    private String cardNumber;

 //   @JsonProperty("exp-month")
    private Integer expMonth;

  //  @JsonProperty("exp-year")
    private Integer expYear;
    private Integer cvc;
    private String dfReferenceId;

    private boolean useCse;
    private boolean riskData;

    public String getEncryptedData() {
        return encryptedData;
    }

    public void setEncryptedData(String encryptedData) {
        this.encryptedData = encryptedData;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public Integer getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(Integer expMonth) {
        this.expMonth = expMonth;
    }

    public Integer getExpYear() {
        return expYear;
    }

    public void setExpYear(Integer expYear) {
        this.expYear = expYear;
    }

    public Integer getCvc() {
        return cvc;
    }

    public void setCvc(Integer cvc) {
        this.cvc = cvc;
    }

    public String getDfReferenceId() {
        return dfReferenceId;
    }

    public void setDfReferenceId(String dfReferenceId) {
        this.dfReferenceId = dfReferenceId;
    }


    public Boolean getUseCse() {
        return useCse;
    }

    public void setUseCse(Boolean useCse) {
        this.useCse = useCse;
    }

    public Boolean getRiskData() {
        return riskData;
    }

    public void setRiskData(Boolean riskData) {
        this.riskData = riskData;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "encryptedData='" + encryptedData + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", expMonth=" + expMonth +
                ", expYear=" + expYear +
                ", cvc=" + cvc +
                ", useCse=" + useCse +
                ", riskData=" + riskData +
                ", dfReferenceId='" + dfReferenceId + '\'' +
                '}';
    }
}
