function getJwt() {
  return fetch("http://localhost:8888/auth").then(response => {
    return response.text()
      .then(text => {
        return text;
      })
    }).catch(function(error) {
      hasError = true;
      errorString += 'The server connection failed! Please try again later.';
    });
}
