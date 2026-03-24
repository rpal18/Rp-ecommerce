package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.exception.ApiException;
import com.ecommerce.Rp_ecommerce.exception.ResourceNotFoundException;
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


import java.util.List;
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

    @Override
    public List<AddressResponseDTO> getUserAddresses(User user) {
        Set<Address> addressList = user.getAddresses();
        List<AddressResponseDTO> response = addressList.stream().
                map(element -> modelMapper.map(element , AddressResponseDTO.class)).toList();
        return response;
    }

    @Override
    @Transactional
    public AddressResponseDTO updateUserAddress(Long addressId, AddressDTO addressDTO) {
        Address address = addressRepository.findById(addressId).orElseThrow(()
                -> new ResourceNotFoundException("Address" ,"AddressId" , addressId ));

        address.setCity(addressDTO.getCity());
        address.setLandmark(addressDTO.getLandmark());
        address.setStreet(addressDTO.getStreet());
        address.setState(addressDTO.getState());
        address.setZipCode(addressDTO.getZipCode());
        address.setCountry(addressDTO.getCountry());
        address.setAddressType(addressDTO.getAddressType());

        Address savedAddress = addressRepository.save(address);
/*
Since , I am making use of Transaction so jpa will do it automatically
*/
//        User user = address.getUser();
//        user.getAddresses().removeIf(element -> element.getAddressId().equals(addressId));
//        user.getAddresses().add(savedAddress);


        return modelMapper.map(savedAddress , AddressResponseDTO.class);
    }

    @Override
    @Transactional
    public String setAddressAsDefault(Long userId  , Long addressId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", userId));


        user.getAddresses().forEach(address -> address.setIsDefault(false));

        Address address = addressRepository.findById(addressId)
                .orElseThrow(() -> new ResourceNotFoundException("Address", "id", addressId));

        if (!address.getUser().getUserId().equals(userId)) {
            throw new ApiException("Address does not belong to this user");
        }

        address.setIsDefault(true);

        return "This address is now default";
    }

    @Override
    @Transactional
    public String deleteAddress(Long addressId) {
        Address address = addressRepository.findById(addressId).
                orElseThrow(()->new ResourceNotFoundException("Address" , "Id" , addressId));

        addressRepository.delete(address);
        return "Address deleted successfully !!";
    }
}
