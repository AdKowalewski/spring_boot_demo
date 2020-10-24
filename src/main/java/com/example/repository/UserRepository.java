package com.example.repository;

import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query("SELECT u FROM User u " +
            " LEFT JOIN FETCH u.addresses" +
            " WHERE u.id = :user_id")
    User findByIdWithAddresses(@Param("user_id") Long id);
}
