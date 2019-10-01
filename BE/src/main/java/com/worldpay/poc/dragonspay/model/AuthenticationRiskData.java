package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "authenticationRiskData")
public class AuthenticationRiskData {

    private AuthenticationTimestamp authenticationTimestamp;
    private String authenticationMethod;

    @XmlElement(name = "authenticationTimestamp")
    public AuthenticationTimestamp getAuthenticationTimestamp() {
        return authenticationTimestamp;
    }

    public void setAuthenticationTimestamp(AuthenticationTimestamp authenticationTimestamp) {
        this.authenticationTimestamp = authenticationTimestamp;
    }

    @XmlAttribute(name = "authenticationMethod")
    public String getAuthenticationMethod() {
        return authenticationMethod;
    }

    public void setAuthenticationMethod(String authenticationMethod) {
        this.authenticationMethod = authenticationMethod;
    }
}
