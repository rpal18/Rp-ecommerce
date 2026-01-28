package com.ecommerce.Rp_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    @Size(min = 2 , max = 20 , message = "Invalid length of user Name ")
    @NotBlank
    private String name;

    @Email
    @NotBlank(message = " please enter email !!")
    private String email;

    @NotBlank
    private String mobileNumber ;
    @Enumerated(EnumType.STRING)
    private AppRole userRole ;

    @NotBlank
    @NotNull
    @Size(min = 6 , max = 30 , message = " password must have at least 6 character")
    private String password ;


    public User(String name, String email, String mobileNumber, AppRole userRole, String password) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userRole = userRole;
        this.password = password;
    }
}
