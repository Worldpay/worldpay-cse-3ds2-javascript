//fetches the JWT required for 3DS DDC
function getJwt() {
  return fetch("[YOUR_AUTH_ENDPOINT]").then(response => {
    return response.text()
      .then(text => {
        return text;
      })
  }).catch(function(error) {
    hasError = true;
    errorString += 'The server connection failed! Please try again later.';
  });
}

