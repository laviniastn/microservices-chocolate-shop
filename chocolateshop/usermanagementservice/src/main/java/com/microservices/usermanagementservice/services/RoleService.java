package com.microservices.usermanagementservice.services;

import com.microservices.usermanagementservice.model.Role;
import com.microservices.usermanagementservice.repositories.RoleRepository;
import com.microservices.usermanagementservice.validators.RoleFieldsValidator;
import com.microservices.utils.errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements Serializable {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleService(RoleRepository userRepository) {
        this.roleRepository = userRepository;
    }

    public List<Role> findAll() {
        List<Role> roles = roleRepository.findAll();
        return roles;
    }

    public Role getByName(String roleName) {

        return roleRepository.findByRoleName(roleName);
    }

    public Role create(Role role) {
        RoleFieldsValidator.validateInsertOrUpdate(role);
        return roleRepository.save(role);
    }

    public Optional<Role> update(Role role) {

        RoleFieldsValidator.validateInsertOrUpdate(role);

        Optional<Role> roleRepo = roleRepository.findById(Math.toIntExact(role.getId()));
        if (!roleRepo.isPresent()) {
            throw new ResourceNotFoundException("Role", "role id", role.getId());
        }

        return roleRepo;
    }

    public void delete(Integer id) {
        this.roleRepository.deleteById(id);
    }
}

