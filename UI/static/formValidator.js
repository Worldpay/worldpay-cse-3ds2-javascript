function submitForm(event, env, bin, jwt) {

    document.getElementById('payButton').disabled = true;

    //merchant validations

    var useCse = document.getElementById('useCse').checked;

    //perform DDC first
    console.log("The DDC process has started. \n BIN: " + bin + ", \n JWT: " + jwt);
    console.log("Using environment: " + env + ".");
    performDDC(env, bin, jwt);

    window.setTimeout(function() {
      document.getElementById('ddcIframe').remove();
      if(useCse) {
        performCSE(); //also performs field validation
        document.getElementById('cardNumber').removeAttribute('name');
        document.getElementById('cardHolderName').removeAttribute('name');
        document.getElementById('expirationMonth').removeAttribute('name');
        document.getElementById('expirationYear').removeAttribute('name');
        document.getElementById('cvcCode').removeAttribute('name');
      } else {
        document.getElementById('encryptedData').removeAttribute('name');
      }
      if(!hasError) {
        document.getElementById('paymentDetailsForm').submit();
      } else {
        alert(errorString);
        document.getElementById('payButton').disabled = false;
        hasError = false;
        errorString = "";
      }
    }, 3000);
};

//creates the DDC iframe object on the fly
function performDDC(env, bin, jwt) {
  let innerHtml =
        "<body onload='document.collectionForm.submit();'>" +
        "<form id='collectionForm' name='collectionForm' method='POST' action='" + env + "'>" +
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
  for(var key in sensitiveData) {
    let value = sensitiveData[key];
    if(!value) {
      value = "";
    }
  }

  //performs encryption and sends the encrypted data back to the server
  document.getElementById('encryptedData').value = Worldpay.encrypt(sensitiveData, errorHandler);
}

//extracts the domain from the environment URL
function extractDomain(url) {
    var searchTerm = "://";
    var index = url.indexOf(searchTerm);
    index = url.indexOf("/", index + searchTerm.length);
    return url.substr(0, index);
}

//event listener for the DDC response
window.addEventListener("message", function(event) {
  console.log("Message received from " + event.origin + ".");
  var domain = extractDomain(getSelectedEnv());

  if(event.origin === domain) {
    console.log("Received device data collection complete event.");
    console.log("Event data: ", event.data);
    let data = JSON.parse(event.data);

    if (data && data.Status && data.SessionId) {
      console.log("Device data collection completed successfully!");
      console.log("Session ID: " + data.SessionId + ".");

      //send the sessionId back to the UI
      document.getElementById('dfReferenceId').value = data.SessionId;

      } else {
        console.log("Device data collection failed. Falling back to 3DS1.");
      }
  }
  }, false);
