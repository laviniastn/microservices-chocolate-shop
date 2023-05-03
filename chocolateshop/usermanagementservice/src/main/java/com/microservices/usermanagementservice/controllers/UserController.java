package com.microservices.usermanagementservice.controllers;

import com.microservices.usermanagementservice.model.User;
import com.microservices.usermanagementservice.services.UserService;
import  com.microservices.utils.hashing.PasswordHash;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;


//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    private static final Logger logger = Logger.getLogger(UserController.class);

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {

        logger.setLevel(Level.DEBUG);
        this.userService = userService;
    }

    @ApiOperation(value = "Get list of users", response = Iterable.class, tags = "getAllUsers")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success|OK"),
            @ApiResponse(code = 401, message = "Not authorized!"),
            @ApiResponse(code = 403, message = "Forbidden!"),
            @ApiResponse(code = 404, message = "Not found!")})
    @GetMapping()
    public ResponseEntity<List<User>> getAllUsers() {

        logger.debug("Get all users");
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Integer id) {
        logger.debug("Get user by id");
        return ResponseEntity.ok().body(userService.findAll().get(id-1));
    }

    @GetMapping(value = "/ping")
    public ResponseEntity<String> getPing() {
        logger.debug("Get user by id");
        return ResponseEntity.status(HttpStatus.CREATED).body("Ping");
    }

    @PostMapping(value = "/create")
    public ResponseEntity<User> createUser(@RequestBody User user) throws NoSuchAlgorithmException {
        logger.debug("Create user");
        String passwordEncode = PasswordHash.hashPassword(user.getUserPassword());
        user.setUserPassword(passwordEncode);
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.insert(user));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<User>  updateUser(@RequestBody User user) {
        logger.debug("Update user");
        return ResponseEntity.ok().body(userService.update(user));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable("id") Integer id) {
        logger.debug("Delete user");
        userService.delete(id);
        return ResponseEntity.ok().body(null);

    }

}

