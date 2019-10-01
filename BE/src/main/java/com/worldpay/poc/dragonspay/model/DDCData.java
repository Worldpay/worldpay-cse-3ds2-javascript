package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "additional3DSData")
@XmlType(propOrder = {"dfReferenceId", "challengeWindowSize", "challengePreference"})
public class DDCData {

    private String dfReferenceId;

    private String challengeWindowSize;

    private String challengePreference;

    @XmlAttribute
    public String getDfReferenceId() {
        return dfReferenceId;
    }

    public void setDfReferenceId(String dfReferenceId) {
        this.dfReferenceId = dfReferenceId;
    }

    @XmlAttribute
    public String getChallengeWindowSize() {
        return challengeWindowSize;
    }

    public void setChallengeWindowSize(String challengeWindowSize) {
        this.challengeWindowSize = challengeWindowSize;
    }

    @XmlAttribute
    public String getChallengePreference() {
        return challengePreference;
    }

    public void setChallengePreference(String challengePreference) {
        this.challengePreference = challengePreference;
    }
}
