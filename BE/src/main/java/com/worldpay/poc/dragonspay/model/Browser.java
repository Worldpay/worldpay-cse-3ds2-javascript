package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "browser")
public class Browser {

    private String acceptHeader;
    private String userAgentHeader;

    public String getAcceptHeader() {
        return acceptHeader;
    }

    public void setAcceptHeader(String acceptHeader) {
        this.acceptHeader = acceptHeader;
    }

    public String getUserAgentHeader() {
        return userAgentHeader;
    }

    public void setUserAgentHeader(String userAgentHeader) {
        this.userAgentHeader = userAgentHeader;
    }
}
