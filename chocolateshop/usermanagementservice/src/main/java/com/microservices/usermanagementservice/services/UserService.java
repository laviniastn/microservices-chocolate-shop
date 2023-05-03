package com.microservices.usermanagementservice.services;

import com.microservices.usermanagementservice.dto.RegistrationDTO;
import com.microservices.usermanagementservice.model.Role;
import com.microservices.usermanagementservice.model.User;
import com.microservices.usermanagementservice.repositories.UserRepository;
import com.microservices.usermanagementservice.validators.UserFieldsValidator;
import com.microservices.utils.errorhandler.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PasswordEncoder passwordEncoder;


    public UserDetails loadUserByUserEmail(String userEmail) throws UsernameNotFoundException {
        User user = getByUserEmail(userEmail);

        if (user == null) {
            throw new UsernameNotFoundException(String.format("User '%s' not found", userEmail));
        } else {
            Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
            user.getRoles().forEach(role -> {
                authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
            });

            return new org.springframework.security.core.userdetails.User(user.getUserEmail(), user.getUserPassword(), authorities);
        }
    }

    public User getByUserEmail(String userEmail) {
        return userRepository.findByUserEmail(userEmail);
    }

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> findAll() {
        List<User> users = userRepository.findAll();
        return users;
    }

    public User insert(User user) {
        UserFieldsValidator.validateInsertOrUpdate(user);
        return userRepository.save(user);
    }

    public User update(User user) {

        UserFieldsValidator.validateInsertOrUpdate(user);

        Optional<User> userRepo = userRepository.findById(Math.toIntExact(user.getId()));
        if (!userRepo.isPresent()) {
            throw new ResourceNotFoundException("User", "user id", user.getId());
        }

        return userRepository.save(user);
    }

    public void delete(Integer id) {
        this.userRepository.deleteById(id);
    }

    public User create(RegistrationDTO request) {
        List<Role> roles = new ArrayList<>();
        try {
            roles.add(roleService.getByName(Role.ROLE_CUSTOMER));
        } catch (Exception ex) {}

        return create(request, roles);
    }

    public User create(RegistrationDTO request, List<Role> roles) {
        User user = new User(request.userEmail(), passwordEncoder.encode(request.password()), roles);
        insert(user);
        return user;
    }

}

