package com.soumyadeep.Assignment.Service;

import com.soumyadeep.Assignment.Model.Customer;
import com.soumyadeep.Assignment.Model.CustomerDTO;
import com.soumyadeep.Assignment.Repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class CustomerService {
  @Autowired
  CustomerRepo customerRepo;

    public ResponseEntity<Customer> save(CustomerDTO customer) {
        Customer newUsser= Customer.builder()
                .uuid(getAlphaNumericString(35))
                .first_name(customer.getFirstName())
                .last_name(customer.getLastName())
                .street(customer.getStreet())
                .address(customer.getAddress())
                .city(customer.getCity())
                .state(customer.getState())
                .email(customer.getEmail())
                .phone(customer.getPhone())
                .build();
        customerRepo.save(newUsser);
        System.out.println(newUsser);
        return new ResponseEntity<>(newUsser, HttpStatus.OK);
    }


    public void delete(String  id) {
        customerRepo.deleteById(id);

    }

    public ResponseEntity<List<Customer>> getall() {
        List<Customer> list=  customerRepo.findAll();
        return new ResponseEntity<>(list, HttpStatus.OK);
    }

    public ResponseEntity<String> update(Customer old) {
        Customer newcus=customerRepo.findById(old.getUuid()).orElse(new Customer());
        newcus.setLast_name(old.getLast_name());
        newcus.setFirst_name(old.getFirst_name());
        newcus.setCity(old.getCity());
        newcus.setAddress(old.getAddress());
        newcus.setState(old.getState());
        newcus.setStreet(old.getStreet());
        newcus.setEmail(old.getEmail());
        newcus.setPhone(old.getPhone());
        customerRepo.save(newcus);
        return new ResponseEntity<>("Updated",HttpStatus.OK);
    }

    public ResponseEntity<List<Customer>> search(String searchBy,String value) {
        List<Customer> list=new ArrayList<>();
        List<Customer> all=customerRepo.findAll();
        if(searchBy.equals("firstName")){
           for(Customer k: all){
               if(k.getFirst_name().equals(value))
                   list.add(k);
           }

        }
        if(searchBy.equals("lastName")){
            for(Customer k: all){
                if(k.getLast_name().equals(value))
                    list.add(k);
            }

        }
        if(searchBy.equals("email")){
            for(Customer k: all){
                if(k.getEmail().equals(value))
                    list.add(k);
            }

        }
        if(searchBy.equals("phone")){
            for(Customer k: all){
                if(k.getPhone().equals(value))
                    list.add(k);
            }

        }
        if(searchBy.equals("city")){
            for(Customer k: all){
                if(k.getCity().equals(value))
                    list.add(k);
            }

        }
        if(searchBy.equals("state")){
            for(Customer k: all){
                if(k.getState().equals(value))
                    list.add(k);
            }

        }

        return new ResponseEntity<>(list,HttpStatus.OK);
    }
    static String getAlphaNumericString(int n)
    {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }


    public ResponseEntity<Customer> fidByID(String id) {
        return new ResponseEntity<>(customerRepo.findById(id).orElse(null),HttpStatus.OK);
    }
}

