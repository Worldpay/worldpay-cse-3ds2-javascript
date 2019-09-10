function submitForm(event, env, bin, jwt) {

  document.getElementById('payButton').disabled = true;

  //other merchant validations

  //perform 3DS DDC
  performDDC(env, bin, jwt);

  window.setTimeout(function() {
    document.getElementById('ddcIframe').remove();

    performCSE(); //also performs field validation

    //do not submit unencrypted card details
    document.getElementById('cardNumber').removeAttribute('name');
    document.getElementById('cardHolderName').removeAttribute('name');
    document.getElementById('expirationMonth').removeAttribute('name');
    document.getElementById('expirationYear').removeAttribute('name');
    document.getElementById('cvcCode').removeAttribute('name');

    if (!hasError) {
      document.getElementById('paymentDetailsForm').submit();
    } else {
      //in case validation errors occur
      alert(errorString);
      document.getElementById('payButton').disabled = false;
      hasError = false;
      errorString = "";
    }
  }, 2000);
  //configurable timeout, form will be submitted after timeout expires
  //DDC response should be received in the meantime
};

//creates the DDC iframe, will be auto-submitted
function performDDC(env, bin, jwt) {
  let innerHtml =
    "<body onload='document.collectionForm.submit();'>" +
    "<form id='collectionForm' name='collectionForm' method='POST' action='" +
    env + "'>" +
    "<input type='hidden' name='Bin' value='" + bin + "'>" +
    "<input type='hidden' name='JWT' value='" + jwt + "'>" +
    "</form>" +
    "</body>";

  //sets iframe properties
  var iframe = document.createElement("iframe");
  iframe.id = "ddcIframe";
  iframe.width = 0;
  iframe.height = 0;
  iframe.style.visibility = "hidden";
  iframe.style.display = "none";
  iframe.target = "_top";
  iframe.srcdoc = innerHtml;

  document.body.appendChild(iframe);
}

//performs CSE - custom integration
function performCSE() {
  var sensitiveData = {
    cardNumber: document.getElementById('cardNumber').value,
    cvc: document.getElementById('cvcCode').value,
    expiryMonth: document.getElementById('expirationMonth').value,
    expiryYear: document.getElementById('expirationYear').value,
    cardHolderName: document.getElementById('cardHolderName').value
  };

  //sets fields to empty if no value is present
  for (var key in sensitiveData) {
    let value = sensitiveData[key];
    if (!value) {
      value = "";
    }
  }

  //performs the encryption
  document.getElementById('encryptedData').value = Worldpay.encrypt(
    sensitiveData, errorHandler);
}

//extracts the domain from the environment URL
function extractDomain(url) {
  var searchTerm = "://";
  var index = url.indexOf(searchTerm);
  index = url.indexOf("/", index + searchTerm.length);
  return url.substr(0, index);
}

//returns the DDC domain - Worldpay Secure Test
function getDdcDomain() {
  return 'https://secure-test.worldpay.com/shopper/3ds/ddc.html';
}

//event listener for the 3DS DDC response
window.addEventListener("message", function(event) {
  var domain = extractDomain(getDdcDomain());

  if (event.origin === domain) {
    let data = JSON.parse(event.data);

    //if message has the correct structure, the sessionId is submitted to the server
    if (data && data.Status && data.SessionId) {
      document.getElementById('dfReferenceId').value = data.SessionId;
    }
  }
}, false);

