package com.ecommerce.Rp_ecommerce.security.jwt.payload;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class UserRequestDTO {


    @NotBlank
    @Size(min = 2, max = 20, message = "Username must be between 2-20 characters")
    private String username;

    @Email
    @NotBlank(message = "Email is required")
    private String email;

    @NotBlank
    @Pattern( regexp = "^(\\+91)?[6-9]\\d{9}$")
    private String mobileNumber;
    @NotBlank
    @Size(min = 6 , message = " password must be greater than 5")
    private String password;

    @NotBlank
    @Size(min = 5  , message = "Street should be of 5 or more than 5 character")
    private String street ;

    @NotBlank
    @Size(min = 5 , message = " City name should be more than 4 character")
    private String city ;
    @NotBlank
    @Size(min = 6 , message = "Zip code should be of valid length ")
    private String zipCode ;
    @NotBlank
    @Size(min=3 , message = " State name should be of more than 2 character")
    private String state;
    @NotBlank
    @Size(min = 4 , message = " Country name should be more than 3 character")
    private String country ;


    public UserRequestDTO(String username, String email, String mobileNumber, String password, String street, String city,
                          String zipCode, String state, String country ) {
        this.username = username;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
    }


    public UserRequestDTO() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
