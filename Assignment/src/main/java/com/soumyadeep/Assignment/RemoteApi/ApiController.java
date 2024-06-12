package com.soumyadeep.Assignment.RemoteApi;

import com.soumyadeep.Assignment.Model.Customer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/sunBase")
public class ApiController {

    private final ApiService apiService;

    public ApiController(ApiService apiService) {
        this.apiService = apiService;
    }

    @GetMapping("/data")
    public List<Customer> getCustomerList() {
        List<Customer> list= apiService.getCustomerList();
        apiService.save(list);
        return list;

    }
}
