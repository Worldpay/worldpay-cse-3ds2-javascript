package com.worldpay.poc.dragonspay.controller;

import com.worldpay.poc.dragonspay.model.Payload;
import com.worldpay.poc.dragonspay.service.PaymentService;
import com.worldpay.poc.dragonspay.util.PaymentResultHtmlHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping(value = "/auth")
    public String generateJWT() {

        return paymentService.generateJWT();
    }

    @PostMapping(value = "/pay", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public String pay(Payload payload) throws JAXBException {

        String xmlReq = paymentService.generateXMLOrder(payload, payload.getUseCse(), payload.getRiskData());
        return new PaymentResultHtmlHelper().createResultHtml(xmlReq);
    }
}
