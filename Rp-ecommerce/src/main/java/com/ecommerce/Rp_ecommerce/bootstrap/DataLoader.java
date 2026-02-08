package com.ecommerce.Rp_ecommerce.bootstrap;

import com.ecommerce.Rp_ecommerce.model.AppRole;
import com.ecommerce.Rp_ecommerce.model.Role;
import com.ecommerce.Rp_ecommerce.model.User;
import com.ecommerce.Rp_ecommerce.repository.RoleRepository;
import com.ecommerce.Rp_ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;


@Component
public class DataLoader implements CommandLineRunner {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public DataLoader(UserRepository userRepository,
                      RoleRepository roleRepository,
                      PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    @Transactional
    public void run(String... args) {

        // 1️⃣ Create ROLE_USER if it doesn't exist
        Role userRole = roleRepository
                .findByRoleName(AppRole.ROLE_USER)
                .orElseGet(() -> {
                    Role role = new Role(AppRole.ROLE_USER);
                    return roleRepository.save(role);
                });

        // 2️⃣ Prevent duplicate user creation
        if (userRepository.existsByUsername("testuser")) {
            return;
        }

        // 3️⃣ Assign role to Set
        Set<Role> roles = new HashSet<>();
        roles.add(userRole);

        // 4️⃣ Create User
        User user = new User();
        user.setUsername("testuser");
        user.setEmail("testuser@gmail.com");
        user.setMobileNumber("9999999999");
        user.setPassword(passwordEncoder.encode("testec@12345"));
        user.setRoles(roles);

        userRepository.save(user);

        System.out.println("✅ ROLE_USER & test user created successfully");
    }

}