package com.soumyadeep.Assignment.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data@Builder
public class Customer {
    @Id
    private String uuid;
    private String email;
    private String first_name;
    private String last_name;
    private String address;
    private String street;
    private String city;
    private String state;
    private String phone;


}
