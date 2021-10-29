package com.stackroute.userservice.repository;

import com.stackroute.userservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @Author Siva
 * @Date 10/29/2021 10:39 AM
 */

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
