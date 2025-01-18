package com.ouaskanas.hahn.security;

import com.ouaskanas.hahn.dao.entities.Roles;
import com.ouaskanas.hahn.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Collections;

@Service
public class UserDetailService implements UserDetailsService {

    private final UserRepository userRepository;

    @Autowired
    public UserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        com.ouaskanas.hahn.dao.entities.User user = userRepository.findByUsername(username);
        return new org.springframework.security.core.userdetails
                .User(user.getUsername(), user.getPassword(),mapRoleAuthorities(user.getRole()));
    }

    private Collection<GrantedAuthority> mapRoleAuthorities(Roles role) {
        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    //todo:REFACTOR USER MANAGEMENT
    public com.ouaskanas.hahn.dao.entities.User getCurrentUser() throws UsernameNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated()) {
            throw new IllegalStateException("No authenticated user found");
        }
        Object principal = authentication.getPrincipal();
        if (principal instanceof org.springframework.security.core.userdetails.User) {
            String username = ((org.springframework.security.core.userdetails.User) principal).getUsername();
            return userRepository.findByUsername(username);
        }
        if (principal instanceof String) {
            String username = (String) principal;
            return userRepository.findByUsername(username);
        }
        throw new IllegalStateException("Authentication principal is not valid");
    }

}
