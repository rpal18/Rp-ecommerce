package com.ecommerce.Rp_ecommerce.controller;

import com.ecommerce.Rp_ecommerce.payload.SignUpResponse;
import com.ecommerce.Rp_ecommerce.security.jwt.payload.UserRequestDTO;
import com.ecommerce.Rp_ecommerce.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/admin")
public class AdminController {

    private UserService userService;

    public AdminController(UserService userService){
        this.userService = userService;
    }

    @PreAuthorize(("hasRole('ADMIN')"))
    @PostMapping("/create-admin")
    public ResponseEntity<?> createAdmin(@Valid @RequestBody UserRequestDTO userRequestDTO){
        SignUpResponse response = userService.registerAdmin(userRequestDTO);
        return ResponseEntity.ok(List.of(response , "User - admin created"));
    }

}
