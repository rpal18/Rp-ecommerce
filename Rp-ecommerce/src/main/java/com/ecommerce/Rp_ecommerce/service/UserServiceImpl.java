package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.Rp_ecommerce.exception.UserAlreadyFoundException;
import com.ecommerce.Rp_ecommerce.model.Address;
import com.ecommerce.Rp_ecommerce.model.AppRole;
import com.ecommerce.Rp_ecommerce.model.Role;
import com.ecommerce.Rp_ecommerce.model.User;
import com.ecommerce.Rp_ecommerce.payload.MessageResponse;
import com.ecommerce.Rp_ecommerce.payload.SignUpResponse;
import com.ecommerce.Rp_ecommerce.repository.RoleRepository;
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
public class UserServiceImpl implements UserService{
    private final UserRepository userRepository;

    private final ModelMapper modelMapper;

   private final PasswordEncoder passwordEncoder;
    @Autowired
    private RoleRepository roleRepository;

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
        Role role = new Role();
        role.setRoleName(AppRole.ROLE_USER);
        userRole.add(roleRepository.findByRoleName(role.getRoleName()).orElseThrow(() ->
                new RuntimeException(" No such role found!!")));
        user.setRoles(userRole);

        user.setEmail(signUpRequest.getEmail());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setUsername(signUpRequest.getUsername());
        user.setMobileNumber(signUpRequest.getMobileNumber());

        User savedUser = userRepository.save(user);
        SignUpResponse response = new SignUpResponse(savedUser.getUserId() , savedUser.getUsername(), savedUser.getEmail());
        return response;
    }

    @Override
    public SignUpResponse registerAdmin(UserRequestDTO userRequestDTO) {
        if (userRepository.existsByUsername(userRequestDTO.getUsername())) {
            throw new UserAlreadyFoundException("Error: Username is already taken!");
        }

        if (userRepository.existsByEmail(userRequestDTO.getEmail())) {
            throw new UserAlreadyFoundException("Error: Email is already in use!");
        }

        Role role = roleRepository.findByRoleName(AppRole.ROLE_ADMIN).orElseThrow(() -> new RuntimeException("Role Not found !!"));
        Set<Role> roles = new HashSet<>();
        roles.add(role);

        User admin = new User(userRequestDTO.getUsername(), userRequestDTO.getEmail(), userRequestDTO.getMobileNumber(),
                passwordEncoder.encode(userRequestDTO.getPassword()), roles );

        User savedAdmin = userRepository.save(admin);


       return new SignUpResponse(savedAdmin.getUserId(), savedAdmin.getUsername(), savedAdmin.getEmail());

    }
}
