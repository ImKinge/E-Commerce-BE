package com.ecommerce.security.service;

import com.ecommerce.entity.Role;
import com.ecommerce.entity.UserData;
import com.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserDetailServiceImpl implements UserDetailsService {


    @Autowired
    private UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserData userData = userRepository.findByUserName(username).orElseThrow(() -> new UsernameNotFoundException("Username not found!"));
        return new User(userData.getUserName(), userData.getPassword(), mapRolesToAuthorities(userData.getRoles()));
    }

    /**
     * Metodo di utility che mi permette di convertire le role in GRANTED AUTHORITIES (autorità concesse)
     * perchè nel metodo loadUserByUsername lo User ha come parametri del costruttore
     * User(String username, String password, Collection<GrantedAuthority> authorities)
     * quindi queste role andranno inserite nella Collection
     *
     * @param roles
     * @return Collection<GrantedAuthority>
     */
    private Collection<GrantedAuthority> mapRolesToAuthorities(List<Role> roles) {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }
}
