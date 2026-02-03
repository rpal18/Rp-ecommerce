package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.exception.UserAlreadyFoundException;
import com.ecommerce.Rp_ecommerce.model.Address;
import com.ecommerce.Rp_ecommerce.model.Role;
import com.ecommerce.Rp_ecommerce.model.User;
import com.ecommerce.Rp_ecommerce.payload.SignUpResponse;
import com.ecommerce.Rp_ecommerce.repository.UserRepository;
import com.ecommerce.Rp_ecommerce.security.jwt.payload.UserRequestDTO;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserServiceImpl  implements UserService{
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

   private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserServiceImpl(UserRepository userRepository  , ModelMapper modelMapper ,
                           PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
        this.passwordEncoder = passwordEncoder;
    }
    @Override
    @Transactional
    public SignUpResponse registerUser(UserRequestDTO signUpRequest) {
        String username = signUpRequest.getUsername();
        String mobileNumber = signUpRequest.getMobileNumber();
        boolean ifExists = userRepository.existsByUsernameAndMobileNumber(username , mobileNumber);
        if(ifExists){
            throw new UserAlreadyFoundException(" User already exits !! please login instead");
        }
        User user = new User();
        Address address = new Address();
        address.setCity(signUpRequest.getCity());
        address.setCountry(signUpRequest.getCountry());
        address.setState(signUpRequest.getState());
        address.setStreet(signUpRequest.getStreet());
        address.setZipCode(signUpRequest.getZipCode());
        Set<Address> addressSet = new HashSet<>();
        addressSet.add(address);
        user.setAddresses(addressSet);
        Set<Role> userRole = new HashSet<>();
        userRole.add(signUpRequest.getRole());
        user.setRoles(userRole);
        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setUsername(signUpRequest.getUsername());
        user.setMobileNumber(signUpRequest.getMobileNumber());

        User savedUser = userRepository.save(user);
        SignUpResponse response = modelMapper.map(savedUser , SignUpResponse.class);
        return response;
    }
}
