package com.soumyadeep.Assignment.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String address;
    private String street;
    private String city;
    private String state;
    private String email;
    private String phone;
}
