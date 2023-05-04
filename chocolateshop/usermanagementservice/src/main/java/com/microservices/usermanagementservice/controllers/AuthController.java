package com.microservices.usermanagementservice.controllers;


import com.microservices.usermanagementservice.model.User;
import com.microservices.usermanagementservice.services.UserService;
import com.microservices.utils.hashing.PasswordHash;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/auth")
public class AuthController {
    private static final Logger logger = Logger.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public AuthController(UserService userService) {

        logger.setLevel(Level.DEBUG);
        this.userService = userService;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<User> loginUser(@RequestBody User user) throws NoSuchAlgorithmException {
        logger.debug("Login user");
        String passwordEncode = PasswordHash.hashPassword(user.getUserPassword());
        user.setUserPassword(passwordEncode);
        return ResponseEntity.ok().body(userService.findByUserEmailAndUserPassword(user.getUserEmail(), user.getUserPassword()));
    }
}
