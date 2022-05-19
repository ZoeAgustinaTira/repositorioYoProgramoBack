package com.portfolio.portfolio.service;

import com.portfolio.portfolio.model.Role;
import com.portfolio.portfolio.model.User;

public interface IUserService {
    User saveUser(User user);

    Role saveRole(Role role);

    void addRoleToUser(String username, String roleName);

    User getUser(String username);
}
