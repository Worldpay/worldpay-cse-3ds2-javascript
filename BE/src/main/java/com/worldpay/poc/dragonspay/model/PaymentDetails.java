package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlTransient
public class PaymentDetails {

    private Session session;

    @XmlElement(name = "session")
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
