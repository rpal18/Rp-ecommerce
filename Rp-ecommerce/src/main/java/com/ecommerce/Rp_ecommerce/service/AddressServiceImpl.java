package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.model.Address;
import com.ecommerce.Rp_ecommerce.model.User;
import com.ecommerce.Rp_ecommerce.payload.AddressDTO;
import com.ecommerce.Rp_ecommerce.payload.AddressResponseDTO;
import com.ecommerce.Rp_ecommerce.repository.AddressRepository;
import com.ecommerce.Rp_ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Set;

@Service
public class AddressServiceImpl implements AddressService{

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AddressRepository addressRepository;

    @Override
    @Transactional
    public AddressResponseDTO createAddress(AddressDTO addressDTO , User user) {
        Address address = modelMapper.map(addressDTO , Address.class);
        address.setName(user.getUsername());
        Set<Address> addressList = user.getAddresses();

        addressList.add(address);

        user.setAddresses(addressList);

        address.setUser(user);

        Address savedAddress = addressRepository.save(address);
        return modelMapper.map(savedAddress , AddressResponseDTO.class);
    }
}
