package com.portfolio.portfolio.controller;


import com.portfolio.portfolio.model.Role;
import com.portfolio.portfolio.model.RoleToUserForm;
import com.portfolio.portfolio.model.User;
import com.portfolio.portfolio.service.IUserService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {
    @Autowired
    private final IUserService userService;

    @CrossOrigin
    @GetMapping("/user/save")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/user(save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveUser(user));

    }
    @CrossOrigin
    @PostMapping("/role/save")
    public ResponseEntity<Role> saveRole(@RequestBody Role role) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/apu/role/save").toUriString());
        return ResponseEntity.created(uri).body(userService.saveRole(role));
    }
    @CrossOrigin
    @PostMapping("/role/addtouser")
    public ResponseEntity<?> addRoleToUser(@RequestBody RoleToUserForm form) {
        userService.addRoleToUser(form.getUsername(), form.getRoleName());
        return ResponseEntity.ok().build();

    }

}