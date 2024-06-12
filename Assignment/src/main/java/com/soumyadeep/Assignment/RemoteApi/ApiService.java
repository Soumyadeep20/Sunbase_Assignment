package com.soumyadeep.Assignment.RemoteApi;

import com.soumyadeep.Assignment.Controller.CustomerController;
import com.soumyadeep.Assignment.Model.Customer;
import com.soumyadeep.Assignment.Model.CustomerDTO;
import com.soumyadeep.Assignment.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;

@Service
public class ApiService {
    @Autowired
    CustomerController customerController;
    @Autowired
    CustomerRepo customerRepo;

    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String token;

    @Autowired
    public ApiService(RestTemplate restTemplate, @Value("${api.url}") String apiUrl, @Value("${api.token}") String token) {
        this.restTemplate = restTemplate;
        this.apiUrl = apiUrl;
        this.token = token;
    }

    public List<Customer> getCustomerList() {
        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.set(HttpHeaders.AUTHORIZATION, token);
        headers.setContentType(MediaType.APPLICATION_JSON);

        // Set parameters
        // Assuming "cmd" is a query parameter
        String urlWithParams = apiUrl + "?cmd=get_customer_list";

        // Combine headers and parameters
        HttpEntity<String> requestEntity = new HttpEntity<>(headers);

        // Make a GET request to the remote API with headers and parameters
        ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(
                urlWithParams,
                HttpMethod.GET,
                requestEntity,
                Customer[].class);

        // Convert array to List
        return List.of(responseEntity.getBody());
    }

    public void save(List<Customer> list) {

        for(Customer k: list){
            Customer check= customerRepo.findById(k.getUuid()).orElse(null);
            if(check==null)
            {
                customerRepo.save(k);
            }
            else{
                Customer newcus=customerRepo.findById(k.getUuid()).orElse(new Customer());
                newcus.setLast_name(k.getLast_name());
                newcus.setFirst_name(k.getFirst_name());
                newcus.setCity(k.getCity());
                newcus.setAddress(k.getAddress());
                newcus.setState(k.getState());
                newcus.setStreet(k.getStreet());
                newcus.setEmail(k.getEmail());
                newcus.setPhone(k.getPhone());
                customerRepo.save(newcus);
            }
        }
    }
}
