package com.ecommerce.Rp_ecommerce.service;

import com.ecommerce.Rp_ecommerce.payload.SignUpResponse;
import com.ecommerce.Rp_ecommerce.security.jwt.payload.UserInfoResponse;
import com.ecommerce.Rp_ecommerce.security.jwt.payload.UserRequestDTO;

public interface UserService {

    SignUpResponse registerUser(UserRequestDTO signUpRequest);

    SignUpResponse registerAdmin(UserRequestDTO userRequestDTO);
}
