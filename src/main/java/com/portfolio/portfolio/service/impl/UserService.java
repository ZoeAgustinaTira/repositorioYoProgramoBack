package com.portfolio.portfolio.service.impl;

import com.portfolio.portfolio.model.Role;
import com.portfolio.portfolio.model.User;
import com.portfolio.portfolio.repository.IRoleRepository;
import com.portfolio.portfolio.repository.IUserRepository;
import com.portfolio.portfolio.service.IUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class UserService implements IUserService, UserDetailsService  {
   @Autowired
   private final IUserRepository userRepository;

   @Autowired
   private final IRoleRepository roleRepository;

   private final PasswordEncoder passwordEncoder;

    @Override
    public User saveUser(User user) {
        log.info("Guardando nuevo usuario {} en la base de datos", user.getUsername());
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public Role saveRole(Role role) {
        log.info("Guardando el nuevo rol {} en la basse de datos", role.getName());
        return roleRepository.save(role);

    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        log.info("Añadiendo rol {} al usuario {}", roleName, username);
        User user = userRepository.findByUsername(username);
        Role role = roleRepository.findByName(roleName);
        user.getRoles().add(role);
    }

    @Override
    public User getUser(String username) {
        log.info("Rastreando usuario {}", username);
        return userRepository.findByUsername(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);

        if (user == null) {
            log.error("Usuario no encontrado en la base de datos");
            throw new UsernameNotFoundException("Usuaruio no encontrado en la base de datos");
        }
        else {
            log.info("Usuario encontrado en la base de datos: {}", username);
        }

        Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
        user.getRoles().forEach(role -> {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        });

        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), authorities);

    }
}

