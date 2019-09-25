package org.kanishka.onclinicwebbackend.model.message;

import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JwtResponse {
    private String userName;
    private String token;
    private String type="Bearer";
    private Collection<String> authorities;
    private String expiresAt;

    public JwtResponse() {
    }

    public JwtResponse(String userName, String token, Collection<? extends GrantedAuthority> authorities, String expiresAt) {
        this.userName = userName;
        this.token = token;
        this.authorities = authorities.stream().map(Object::toString).collect(Collectors.toList());
        this.expiresAt=expiresAt;
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

    public Collection<String> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Collection<String> authorities) {
        this.authorities = authorities;
    }

    public String getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(String expiresAt) {
        this.expiresAt = expiresAt;
    }
}
