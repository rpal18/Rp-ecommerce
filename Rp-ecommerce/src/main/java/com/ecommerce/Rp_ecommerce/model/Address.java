package com.ecommerce.Rp_ecommerce.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.modelmapper.internal.bytebuddy.build.ToStringPlugin;

import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "adresses")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long addressId ;
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

    // Since one many user can have multiple address  , similarly many addresses belongs to the same user
    // That is why we will make this relationship as many to many
    @ManyToMany(mappedBy = "addresses")
    private List<User> users = new ArrayList<>();

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
    public void setUsers(List<User> users) {
        this.users = users;
    }
}
