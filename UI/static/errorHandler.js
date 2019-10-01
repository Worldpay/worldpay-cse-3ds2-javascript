var errorString = "";
var hasError = false;

function errorHandler(errorCodes) {
  if(errorCodes.includes(101) || errorCodes.includes(103)) {
    hasError = true;
    errorString += "\n Please enter a valid card number.";
  }
  if(errorCodes.includes(102)) {
    hasError = true;
    errorString += "\n The card number length is not valid.";
  }
  if(errorCodes.includes(201)) {
    hasError = true;
    errorString += "\n Please enter a valid CVC.";
  }
  if(errorCodes.includes(301) || errorCodes.includes(303)) {
    hasError = true;
    errorString += "\n Please enter a valid expiry month.";
  }
  if(errorCodes.includes(302)) {
    hasError = true;
    errorString += "\n The expiry month length is not valid.";
  }
  if(errorCodes.includes(304)) {
    hasError = true;
    errorString += "\n Please enter a valid expiry year.";
  }
  if(errorCodes.includes(305)) {
    hasError = true;
    errorString += "\n The expiry year length is not valid.";
  }
  if(errorCodes.includes(306)) {
    hasError = true;
    errorString += "\n The expiry date is in the past.";
  }
  if(errorCodes.includes(401)) {
    hasError = true;
    errorString += "\n Please enter a valid cardholder name.";
  }
  if(errorCodes.includes(402)) {
    hasError = true;
    errorString += "\n The cardholder name cannot be longer than 30 characters.";
  }
}
