package com.worldpay.poc.dragonspay.util;

public class PaymentResultHtmlHelper {

    public String createResultHtml(String xml) {
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "  <title>Payment result</title>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2 style=\"color: red;\">Dragons Pay</h2>\n" +
                "<p id=\"successMsg\" style=\"font-weight: bold;\">Click the text area to copy the content!</p>\n" +
                "  <textarea id=\"reqXml\" style=\"height: 500px; width:100%; resize=none;\" onclick=\"copyText();\" readonly=\"true\">\n" +
                xml +
                "  </textarea>\n" +
                "<script>\n" +
                "function copyText() {\n" +
                "document.getElementById('reqXml').select();\n" +
                "document.execCommand('copy');\n" +
                "document.getElementById('successMsg').innerHTML = \"XML text copied to clipboard!\";\n" +
                "}\n" +
                "</script>\n" +
                "</body>\n" +
                "</html>";

        return html;
    }
}
