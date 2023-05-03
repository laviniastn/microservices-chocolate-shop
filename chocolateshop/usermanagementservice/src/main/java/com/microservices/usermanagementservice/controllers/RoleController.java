package com.microservices.usermanagementservice.controllers;

import com.microservices.usermanagementservice.model.Role;
import com.microservices.usermanagementservice.services.RoleService;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping(value = "/roles")
public class RoleController {

    private static final Logger logger = Logger.getLogger(RoleController.class);

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        logger.setLevel(Level.DEBUG);
        this.roleService = roleService;
    }

    @GetMapping()
    public ResponseEntity<List<Role>> getAllRoles() {

        logger.debug("Get all roles");
        return ResponseEntity.ok().body(roleService.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Role> getRoleById(@PathVariable("id") Integer id) {
        logger.debug("Get  role by id");
        return ResponseEntity.ok().body(roleService.findAll().get(id));
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Role> createRole(@RequestBody Role role) {

        logger.debug("Create role");
        return ResponseEntity.status(HttpStatus.CREATED).body(roleService.create(role));
    }

    @PutMapping(value = "/update")
    public ResponseEntity<Optional<Role>> updateRole(@RequestBody Role role) {
        logger.debug("Update role");
        return ResponseEntity.ok().body(roleService.update(role));
    }

    @DeleteMapping(value = "/delete/{id}")
    public ResponseEntity deleteRoleById(@PathVariable("id") Integer id) {
        logger.debug("Delete role");
        roleService.delete(id);
        return ResponseEntity.ok().body(null);
    }

}

