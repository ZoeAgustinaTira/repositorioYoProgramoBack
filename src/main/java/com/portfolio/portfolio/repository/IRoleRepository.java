package com.portfolio.portfolio.repository;

import com.portfolio.portfolio.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IRoleRepository extends JpaRepository<Role, Integer> {
    Role findByName(String name);
}
