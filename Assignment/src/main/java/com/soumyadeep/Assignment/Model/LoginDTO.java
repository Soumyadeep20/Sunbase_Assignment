package com.soumyadeep.Assignment.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Getter
@Setter
public class LoginDTO {


    private String id;
    private String password;
}