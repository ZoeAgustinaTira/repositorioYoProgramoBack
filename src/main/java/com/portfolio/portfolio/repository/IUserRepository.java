package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);
}
