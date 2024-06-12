document.getElementById('loginForm').addEventListener('submit', function(event) {
    event.preventDefault();

    // Define the body data
    const user = {
        id: document.getElementById('id').value,
        password: document.getElementById('password').value
    };

 console.log(user);

      // Define the URL of the API endpoint
      const apiUrl = 'http://localhost:8080/user/login';

      // Define the options for the fetch request
      const requestOptions = {
        method: 'POST', // or 'GET', 'PUT', 'DELETE', etc. depending on your API
        headers: {
          'Content-Type': 'application/json' // Specify the content type
        },
        body: JSON.stringify(user) // Convert the body data to JSON format
      };

      // Make the fetch request
      fetch(apiUrl, requestOptions)
        .then(response => {
          if (!response.ok) {
            throw new Error('Network response was not ok');
          }
          return response.json(); // Parse the JSON response
        })
        .then(data => {
          // Handle the response data
          console.log(data);

          const authToken = data.jwtToken;

              // Store the token in local storage
              localStorage.setItem('token', authToken);


        })
        .catch(error => {
          // Handle any errors
          console.error('There was a problem with the fetch operation:', error);
        });

        window.location.href = 'home.html';


});