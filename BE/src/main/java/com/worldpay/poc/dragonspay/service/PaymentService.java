package com.worldpay.poc.dragonspay.service;

import com.worldpay.poc.dragonspay.model.*;
import com.worldpay.poc.dragonspay.util.DateTimeUtils;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.security.Key;
import java.sql.Timestamp;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Service
public class PaymentService {

    @Value("${jwt.apiKey}")
    private String apiKey;

    @Value("${jwt.apiIdentifier}")
    private String apiIdentifier;

    @Value("${jwt.orgUnitId}")
    private String orgUnitId;

    @Value("${jwt.tokenDuration}")
    private String tokenDuration;

    @Value("${xml.DTD}")
    private String DTD;

    public String generateJWT() {

        String jwtId = UUID.randomUUID().toString();

        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long nowMillis = System.currentTimeMillis();
        java.util.Date date = new java.util.Date(nowMillis);

        byte[] apiKeySecretBytes = apiKey.getBytes();
        Key signingKey = new SecretKeySpec(apiKeySecretBytes, signatureAlgorithm.getJcaName());

        JwtBuilder builder = Jwts.builder()
                .setId(jwtId)
                .setIssuedAt(date)
                .setIssuer(apiIdentifier)
                .claim("OrgUnitId", orgUnitId)
                .signWith(signingKey);

        long tokenDurationMillis = DateTimeUtils.getTimeInMillisFrom(tokenDuration);

        if (tokenDurationMillis > 0) {
            long expMillis = nowMillis + tokenDurationMillis;
            java.util.Date exp = new java.util.Date(expMillis);
            builder.setExpiration(exp);
        }

        return builder.compact();
    }

    public String generateXMLOrder(Payload payload, Boolean hasCSE, Boolean hasRiskData) throws JAXBException {

        DirectXMLContent xmlContent = generateXMLObjectTree(payload, hasCSE, hasRiskData);

        JAXBContext context = JAXBContext.newInstance(DirectXMLContent.class);
        Marshaller marshaller = context.createMarshaller();
        StringWriter stringWriter = new StringWriter();
        stringWriter.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        stringWriter.append(String.format("%s\n", DTD));

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.setProperty("com.sun.xml.internal.bind.xmlDeclaration", Boolean.FALSE);
        marshaller.marshal(xmlContent, stringWriter);

        String xmlResult = stringWriter.toString().replace("&amp;lt;", "<");
        xmlResult = xmlResult.replace("&amp;gt;", ">");

        return xmlResult;
    }

    private DirectXMLContent generateXMLObjectTree(Payload payload, Boolean hasCSE, Boolean hasRiskData) {
        DirectXMLContent paymentService = new DirectXMLContent();
        paymentService.setMerchantCode("ALEXPROBA");
        paymentService.setVersion(1.4);

        PaymentContent submit = new PaymentContent();

        Order order = new Order();

        order.setDescription("Test order for ALEXPROBA");
        order.setOrderContent("&lt;![CDATA[]]&gt;");
        order.setOrderCode(Long.toString(System.currentTimeMillis()));

        Amount amount = new Amount();

        amount.setCurrencyCode("EUR");
        amount.setExponent(2);
        amount.setValue(ThreadLocalRandom.current().nextInt(100, 100000));

        order.setAmount(amount);

        Session session = new Session();

        session.setShopperIPAddress("127.0.0.1");
        session.setId("ssn516181942");

        if (hasCSE) {
            PaymentDetailsCSE paymentDetails = new PaymentDetailsCSE();

            CSEData cseData = new CSEData();

            cseData.setEncryptedData(payload.getEncryptedData());

            CardAddress cardAddress = new CardAddress();

            Address address = new Address();
            address.setFirstName("Mr Bert");
            address.setAddress1("Worldpay");
            address.setAddress2("270-289 The Science Park");
            address.setAddress3("Milton Road");
            address.setPostalCode("CB4 0WE");
            address.setCity("Cambridge");
            address.setCountryCode("GB");

            cardAddress.setAddress(address);
            cseData.setCardAddress(cardAddress);

            paymentDetails.setCseData(cseData);

            paymentDetails.setSession(session);
            order.setPaymentDetails(paymentDetails);

        } else {
            PaymentDetailsNonCSE paymentDetails = new PaymentDetailsNonCSE();

            CardSSL cardSSL = new CardSSL();

            cardSSL.setCardNumber(payload.getCardNumber());
            cardSSL.setCardHolderName(payload.getCardHolderName());
            cardSSL.setCvc(payload.getCvc());

            CardAddress cardAddress = new CardAddress();

            Address address = new Address();
            address.setFirstName("Mr Bert");
            address.setAddress1("Worldpay");
            address.setAddress2("270-289 The Science Park");
            address.setAddress3("Milton Road");
            address.setPostalCode("CB4 0WE");
            address.setCity("Cambridge");
            address.setCountryCode("GB");

            cardAddress.setAddress(address);

            cardSSL.setCardAddress(cardAddress);

            paymentDetails.setCardSSL(cardSSL);

            ExpiryDate expiryDate = new ExpiryDate();
            ExpiryDateDetails date = new ExpiryDateDetails();
            date.setMonth(String.valueOf(payload.getExpMonth()));
            date.setYear(payload.getExpYear());
            expiryDate.setExpiryDateDetails(date);

            cardSSL.setExpiryDate(expiryDate);

            paymentDetails.setSession(session);
            order.setPaymentDetails(paymentDetails);
        }

        Shopper shopper = new Shopper();
        Browser browser = new Browser();

        browser.setAcceptHeader("text/html");
        browser.setUserAgentHeader("Mozilla/5.0");
        shopper.setBrowser(browser);
        order.setShopper(shopper);

        ShippingAddress shippingAddress = new ShippingAddress();

        Address address = new Address();
        address.setFirstName("A");
        address.setLastName("Customer");
        address.setAddress1("1 A Place");
        address.setAddress2("A Town");
        address.setAddress3("Maybe");
        address.setPostalCode("CB1 0EE");
        address.setCity("Somewhere");
        address.setCountryCode("GB");
        address.setTelephoneNumber("00000000000");

        shippingAddress.setAddress(address);
        order.setShippingAddress(shippingAddress);

        if (hasRiskData) {
            RiskData riskData = generateRiskData();
            order.setRiskData(riskData);
        }

        DDCData ddcData = new DDCData();
        ddcData.setDfReferenceId(payload.getDfReferenceId());
        ddcData.setChallengeWindowSize("250x400");
        ddcData.setChallengePreference("challengeMandated");
        order.setAdditional3DSData(ddcData);

        submit.setOrder(order);
        paymentService.setSubmit(submit);

        return paymentService;
    }

    private RiskData generateRiskData() {

        RiskData riskData = new RiskData();
        AuthenticationRiskData authenticationRiskData = new AuthenticationRiskData();
        ShopperAccountRiskData shopperAccountRiskData = new ShopperAccountRiskData();
        TransactionRiskData transactionRiskData = new TransactionRiskData();

        AuthenticationTimestamp authenticationTimestamp = new AuthenticationTimestamp();

        Date authDate = new Date();
        authDate.setSecond("01");
        authDate.setMinute("02");
        authDate.setHour("03");
        authDate.setDayOfMonth("01");
        authDate.setMonth("01");
        authDate.setYear(2019);

        authenticationTimestamp.setDate(authDate);
        authenticationRiskData.setAuthenticationMethod("guestCheckout");
        authenticationRiskData.setAuthenticationTimestamp(authenticationTimestamp);

        ShopperAccountCreationDate shopperAccountCreationDate = new ShopperAccountCreationDate();
        ShopperAccountModificationDate shopperAccountModificationDate = new ShopperAccountModificationDate();
        ShopperAccountPasswordChangeDate shopperAccountPasswordChangeDate = new ShopperAccountPasswordChangeDate();
        ShopperAccountShippingAddressFirstUseDate shopperAccountShippingAddressFirstUseDate = new ShopperAccountShippingAddressFirstUseDate();
        ShopperAccountPaymentAccountFirstUseDate shopperAccountPaymentAccountFirstUseDate = new ShopperAccountPaymentAccountFirstUseDate();

        List<Date> dates = Stream.generate(Date::new).limit(5)
                .map(date -> DateTimeUtils.generateNextDate())
                .collect(toList());

        shopperAccountCreationDate.setDate(dates.get(0));
        shopperAccountModificationDate.setDate(dates.get(1));
        shopperAccountPasswordChangeDate.setDate(dates.get(2));
        shopperAccountShippingAddressFirstUseDate.setDate(dates.get(3));
        shopperAccountPaymentAccountFirstUseDate.setDate(dates.get(4));

        shopperAccountRiskData.setTransactionsAttemptedLastDay(4);
        shopperAccountRiskData.setTransactionsAttemptedLastYear(2);
        shopperAccountRiskData.setPurchasesCompletedLastSixMonths(1);
        shopperAccountRiskData.setAddCardAttemptsLastDay(0);
        shopperAccountRiskData.setPreviousSuspiciousActivity(false);
        shopperAccountRiskData.setShippingNameMatchesAccountName(true);
        shopperAccountRiskData.setShopperAccountCreationDate(shopperAccountCreationDate);
        shopperAccountRiskData.setShopperAccountModificationDate(shopperAccountModificationDate);
        shopperAccountRiskData.setShopperAccountPasswordChangeDate(shopperAccountPasswordChangeDate);
        shopperAccountRiskData.setShopperAccountShippingAddressFirstUseDate(shopperAccountShippingAddressFirstUseDate);
        shopperAccountRiskData.setShopperAccountPaymentAccountFirstUseDate(shopperAccountPaymentAccountFirstUseDate);

        transactionRiskData.setShippingMethod("shipToBillingAddress");
        transactionRiskData.setDeliveryTimeframe("electronicDelivery");
        transactionRiskData.setDeliveryEmailAddress("sp@worldpay.com");
        transactionRiskData.setReorderingPreviousPurchases(false);
        transactionRiskData.setPreOrderPurchase(true);
        transactionRiskData.setGiftCardCount(2);

        Amount transactionRiskAmount = new Amount();
        transactionRiskAmount.setValue(1);
        transactionRiskAmount.setCurrencyCode("EUR");
        transactionRiskAmount.setExponent(2);

        TransactionRiskDataGiftCardAmount transactionRiskDataGiftCardAmount = new TransactionRiskDataGiftCardAmount();
        transactionRiskDataGiftCardAmount.setAmount(transactionRiskAmount);

        TransactionRiskDataPreOrderDate transactionRiskDataPreOrderDate = new TransactionRiskDataPreOrderDate();
        transactionRiskDataPreOrderDate.setDate(DateTimeUtils.generateNextDate());

        transactionRiskData.setTransactionRiskDataGiftCardAmount(transactionRiskDataGiftCardAmount);
        transactionRiskData.setTransactionRiskDataPreOrderDate(transactionRiskDataPreOrderDate);

        riskData.setAuthenticationRiskData(authenticationRiskData);
        riskData.setShopperAccountRiskData(shopperAccountRiskData);
        riskData.setTransactionRiskData(transactionRiskData);
        return riskData;
    }
}
