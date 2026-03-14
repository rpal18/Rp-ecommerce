package com.ecommerce.Rp_ecommerce.payload;

public class AddressResponseDTO {
    private Long addressId ;

    private String city ;
    private String zipCode ;
    private String state;
    private String country ;

    private String name;
    private String landmark;

    public AddressResponseDTO(Long addressId, String city, String zipCode, String state,
                              String country , String name , String landmark) {
        this.addressId = addressId;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.name = name ;
        this.landmark = landmark;
    }

    public AddressResponseDTO() {
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }
}
