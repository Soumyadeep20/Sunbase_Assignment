package com.soumyadeep.Assignment.Controller;

import ch.qos.logback.core.model.Model;
import com.soumyadeep.Assignment.Model.Customer;
import com.soumyadeep.Assignment.Model.CustomerDTO;
import com.soumyadeep.Assignment.Service.CustomerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@AllArgsConstructor
@Slf4j
//To create new Customer
@RequestMapping("/customer")
public class CustomerController {

   @Autowired
    CustomerService customerService;
   @CrossOrigin(origins="http://localhost:8080/customer/save")
    @PostMapping("/save")
    public ResponseEntity<Customer> save(@RequestBody CustomerDTO customer)
    {
        System.out.println(customer);
        return customerService.save(customer);



    }
    @GetMapping("/getById")
    public ResponseEntity<Customer> fidByID(@RequestParam String id)
    {
        return customerService.fidByID(id);
    }
    @GetMapping("/allCustomerList")
    public ResponseEntity<List<Customer>> getall()
    {
        return customerService.getall();
    }

   @DeleteMapping("/delete")
   public void delete(@RequestParam String id)
    {
        customerService.delete(id);
    }
   //To update customer
    @PutMapping("/update")
    public ResponseEntity<String> update(@RequestBody Customer old)
    {
        return customerService.update(old);
    }
    // to Searching based on parameter and value
    @GetMapping("/search")
    public ResponseEntity<List<Customer>> search(@RequestParam String searchBy, @RequestParam String value)
    {
        return customerService.search(searchBy,value);
    }
}
