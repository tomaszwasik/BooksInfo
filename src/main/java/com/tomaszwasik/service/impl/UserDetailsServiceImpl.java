package com.tomaszwasik.service.impl;

import com.tomaszwasik.entity.RoleEntity;
import com.tomaszwasik.entity.UserEntity;
import com.tomaszwasik.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Tomasz Wąsik, tomaszwasik@live.com
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.findByUsername(username);

        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        for (RoleEntity roleEntity : userEntity.getRoles()){
            grantedAuthorities.add(new SimpleGrantedAuthority(roleEntity.getName()));
        }
        return new User(userEntity.getUsername(), userEntity.getPassword(), grantedAuthorities);
    }
}
