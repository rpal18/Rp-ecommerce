package com.ecommerce.Rp_ecommerce.payload;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;

public class OrderRequestDTO {

    @Valid
    private List<OrderItemDTO> items;

    @NotBlank
    @Size(min = 5, max = 100)
    private String street;

    @NotBlank
    @Size(min = 3, max = 50)
    private String city;

    @NotBlank
    @Size(min = 3, max = 50)
    private String state;

    @NotBlank
    @Pattern(regexp = "\\d{6}", message = "Zip code must be 6 digits")
    private String zipCode;

    @NotBlank
    @Size(min = 4, max = 50)
    private String country;

    public OrderRequestDTO() {
    }

    public OrderRequestDTO(List<OrderItemDTO> items, String street,
                           String city, String state, String zipCode, String country) {
        this.items = items;
        this.street = street;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public List<OrderItemDTO> getItems() {
        return items;
    }

    public void setItems(List<OrderItemDTO> items) {
        this.items = items;
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}