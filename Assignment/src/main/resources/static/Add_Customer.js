
document.getElementById('customerForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const p = document.getElementById('p1');
    p.innerText = "hi";
    // Define the body data
    const customer = {
        firstName: document.getElementById('firstName').value,
        lastName: document.getElementById('lastName').value,
        street: document.getElementById('street').value,
        address: document.getElementById('address').value,
        city: document.getElementById('city').value,
        state: document.getElementById('state').value,
        email: document.getElementById('email').value,
        phone: document.getElementById('phone').value
    };


    console.log(customer)
      // Define the URL of the API endpoint
      const apiUrl = 'http://localhost:8080/user/save';

      //Store the token
       const authToken =  localStorage.getItem('token');

      // Define the options for the fetch request
      const requestOptions = {
        method: 'POST', //
        headers: {
         'Content-Type': 'application/json', // Specify the content type
             'Authorization':  `Bearer ${authToken}` // Include the authentication token in the header
        },
        body: JSON.stringify(customer) // Convert the body data to JSON format
      };
      console.log(requestOptions);
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
        })
        .catch(error => {
          // Handle any errors
          console.error('There was a problem with the fetch operation:', error);
        });


      // window.location.href = 'home.html';

});