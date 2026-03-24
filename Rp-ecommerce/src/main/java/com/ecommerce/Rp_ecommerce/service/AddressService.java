package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.model.User;
import com.ecommerce.Rp_ecommerce.payload.AddressDTO;
import com.ecommerce.Rp_ecommerce.payload.AddressResponseDTO;

import java.util.List;

public interface AddressService {

    AddressResponseDTO createAddress(AddressDTO addressDTO , User user);

    List<AddressResponseDTO> getUserAddresses(User user);
}
