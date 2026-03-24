package com.ecommerce.Rp_ecommerce.controller;

import com.ecommerce.Rp_ecommerce.model.User;
import com.ecommerce.Rp_ecommerce.payload.AddressDTO;
import com.ecommerce.Rp_ecommerce.payload.AddressResponseDTO;
import com.ecommerce.Rp_ecommerce.service.AddressService;
import com.ecommerce.Rp_ecommerce.utils.AuthUtils;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class AddressController {

    private final AddressService addressService;
    private final AuthUtils authUtils;

    @Autowired
    public AddressController(AddressService addressService , AuthUtils authUtils){
        this.addressService = addressService;
        this.authUtils = authUtils;
    }
    @PostMapping("/addresses")
    public ResponseEntity<AddressResponseDTO> createAddress(@Valid @RequestBody AddressDTO addressDTO){
        User user = authUtils.loggedInUser();
        AddressResponseDTO addressDTO1 = addressService.createAddress(addressDTO , user);
        return new ResponseEntity<>(addressDTO1 , HttpStatus.CREATED);
    }

    @GetMapping("/users/addresses")
    public ResponseEntity<List<AddressResponseDTO>> getAddresses(){
        User user = authUtils.loggedInUser();
        List<AddressResponseDTO> response = addressService.getUserAddresses(user);
        return new ResponseEntity<>(response , HttpStatus.OK);
    }

    @PutMapping("/users/addresses/{addressId}")
    public ResponseEntity<AddressResponseDTO> updateUserAddress(@PathVariable Long addressId ,
                                                               @Valid @RequestBody AddressDTO addressDTO){
        AddressResponseDTO addressResponseDTO = addressService.updateUserAddress(addressId , addressDTO);
        return new ResponseEntity<>(addressResponseDTO , HttpStatus.OK);
    }

   @PatchMapping("/users/addresses/{addressId}/default")
    public ResponseEntity<String> setAddressAsDefault(@PathVariable Long addressId){
       User user = authUtils.loggedInUser();
       Long userId = user.getUserId();
       String messsage = addressService.setAddressAsDefault(userId ,addressId);
       return new ResponseEntity<>(messsage , HttpStatus.OK);
   }

}
