package com.ecommerce.Rp_ecommerce.payload;
import com.ecommerce.Rp_ecommerce.model.AddressType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class AddressDTO {


    @NotBlank
    @Size(min = 5  , message = "Street should be of 5 or more than 5 character")
    private String street ;

    @NotBlank
    @Size(min = 5 , message = " City name should be more than 4 character")
    private String city ;
    @NotBlank
    @Pattern(regexp = "\\d{6}" , message = "Zip code must be of 6 digit")
    private String zipCode ;
    @NotBlank
    @Size(min=3 , max = 20, message = " State name should be of more than 2 character")
    private String state;
    @NotBlank
    @Size(min = 4 , max = 20 , message = " Country name should be more than 3 character")
    private String country ;
    @NotBlank
    @Size(min = 10 , max = 50 , message = "landmark must be of min 10 and max 50 character long")
    private String landmark;
    @NotNull
    private AddressType addressType;

    public AddressDTO() {
    }

    public AddressDTO( String street, String city, String zipCode, String state, String country,String landmark , AddressType addressType) {
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.state = state;
        this.country = country;
        this.landmark  = landmark;
        this.addressType = addressType;
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

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public AddressType getAddressType() {
        return addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }
}
