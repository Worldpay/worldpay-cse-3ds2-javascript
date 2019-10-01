package com.worldpay.poc.dragonspay.model;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

@XmlRootElement(name = "date")
@XmlType(propOrder = {"month", "year"})
public class ExpiryDateDetails {

    private String month;
    private Integer year;

    @XmlAttribute
    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    @XmlAttribute
    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
