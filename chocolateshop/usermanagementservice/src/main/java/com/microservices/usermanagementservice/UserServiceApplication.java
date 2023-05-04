package com.microservices.usermanagementservice;
import com.microservices.usermanagementservice.dto.RegistrationDTO;
import com.microservices.usermanagementservice.services.RoleService;
import com.microservices.usermanagementservice.services.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.microservices.usermanagementservice.model.Role;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class UserServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner run(UserService userService, RoleService roleService) {
        return args -> {
            Role roleCustomer = roleService.create(new Role(Role.ROLE_CUSTOMER));
            Role roleSeller = roleService.create(new Role(Role.ROLE_SELLER));
            Role roleAdmin = roleService.create(new Role(Role.ROLE_ADMIN));


            List<Role> roles1 = new ArrayList<>();
            roles1.add(roleCustomer);

            List<Role> roles2 = new ArrayList<>();
            roles2.add(roleSeller);

            List<Role> roles3 = new ArrayList<>();
            roles3.add(roleAdmin);

            userService.create(new RegistrationDTO("Ana","Pop","customer@gmail.com" , "12345"), roles1);
            userService.create(new RegistrationDTO("Ioan","Serban","seller@gmail.com", "12345"), roles2);
            userService.create(new RegistrationDTO("Lavinia","Stan","admin@gmail.com", "12345"), roles3);

        };
    }
}
