package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.model.User;
import com.ecommerce.Rp_ecommerce.payload.AddressDTO;
import com.ecommerce.Rp_ecommerce.payload.AddressResponseDTO;

public interface AddressService {

    AddressResponseDTO createAddress(AddressDTO addressDTO , User user);
}
