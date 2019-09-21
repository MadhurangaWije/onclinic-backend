package org.kanishka.onclinicwebbackend.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class UserPrinciple implements UserDetails {

    private String username;
    private String password;
    private List<? extends GrantedAuthority> athorities;
    private boolean enabled;

    public UserPrinciple() {
    }

    public UserPrinciple(Users users) {
        this.username=users.getEmail();
        this.password= users.getPassword();
        this.athorities=users.getRoles().stream().map(roles -> new SimpleGrantedAuthority(roles.toString())).collect(Collectors.toList());
        this.enabled=users.isEnabled();
    }

    public UserPrinciple(String username, String password, List<? extends GrantedAuthority> athorities, boolean enabled) {
        this.username = username;
        this.password = password;
        this.athorities = athorities;
        this.enabled = enabled;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return athorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
