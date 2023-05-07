package com.microservices.usermanagementservice.repositories;

import com.microservices.usermanagementservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM users u WHERE u.user_email= :email", nativeQuery = true)
    User findByUserEmail(@Param("email") String userEmail);

    @Query(value = "SELECT * FROM users u WHERE u.user_email= :email and u.user_password= :password", nativeQuery = true)
    User findByUserEmailAndUserPassword(@Param("email") String userEmail, @Param("password") String userPassword);
}
