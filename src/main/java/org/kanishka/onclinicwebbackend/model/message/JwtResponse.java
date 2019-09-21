package org.kanishka.onclinicwebbackend.model.message;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtResponse {
    private String userName;
    private String token;
    private String type="Bearer";
    private Collection<? extends GrantedAuthority> authorities;

    public JwtResponse() {
    }

    public JwtResponse(String userName, String token, Collection<? extends GrantedAuthority> authorities) {
        this.userName = userName;
        this.token = token;
        this.authorities = authorities;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
