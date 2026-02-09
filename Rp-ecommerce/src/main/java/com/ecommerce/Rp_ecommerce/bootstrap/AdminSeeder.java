package com.ecommerce.Rp_ecommerce.bootstrap;

import com.ecommerce.Rp_ecommerce.model.AppRole;
import com.ecommerce.Rp_ecommerce.model.Role;
import com.ecommerce.Rp_ecommerce.model.User;
import com.ecommerce.Rp_ecommerce.repository.RoleRepository;
import com.ecommerce.Rp_ecommerce.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;
@Component
public class AdminSeeder implements CommandLineRunner {
    private RoleRepository roleRepository;
    private UserRepository userRepository;

    private PasswordEncoder passwordEncoder;
    @Autowired

    public AdminSeeder(RoleRepository roleRepository , UserRepository userRepository ,
                       PasswordEncoder passwordEncoder ){

        this.passwordEncoder = passwordEncoder;
        this.roleRepository  = roleRepository;
        this.userRepository = userRepository;

    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {

            Role adminRole = roleRepository.findByRoleName(AppRole.ROLE_ADMIN)
                    .orElseGet(() -> roleRepository.save(new Role(AppRole.ROLE_ADMIN)));

            Role userRole = roleRepository.findByRoleName(AppRole.ROLE_USER)
                    .orElseGet(() -> roleRepository.save(new Role(AppRole.ROLE_USER)));

            // 2. Check if Super Admin exists
            if (!userRepository.existsByUsername("superadmin")) {
                Set<Role> roles = new HashSet<>();
                roles.add(adminRole);
                // 3. Create the Super Admin
                User admin = new User(
                        "superadmin",
                        "superadmin@gmail.com",
                        "+918789067869",
                        passwordEncoder.encode("admin123"), roles
                );
                userRepository.save(admin);

                System.out.println("-------------------------------------");
                System.out.println("   SUPER ADMIN ACCOUNT CREATED       ");
                System.out.println("   Username: superadmin              ");
                System.out.println("   Password: admin123                ");
                System.out.println("-------------------------------------");
            }

    }
}
