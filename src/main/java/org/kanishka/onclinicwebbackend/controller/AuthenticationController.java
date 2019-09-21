package org.kanishka.onclinicwebbackend.controller;

import org.kanishka.onclinicwebbackend.model.message.JwtRequest;
import org.kanishka.onclinicwebbackend.model.message.JwtResponse;
import org.kanishka.onclinicwebbackend.security.jwt.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class AuthenticationController {

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    @Qualifier("custom-user-details-service")
    UserDetailsService userDetailsService;

    @Autowired
    JwtProvider jwtProvider;


    @PostMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody JwtRequest request) throws Exception {

        Authentication authentication=authenticate(request.getEmail(),request.getPassword());
        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getEmail());
        String token=jwtProvider.generateToken(authentication);
       return ResponseEntity.ok(new JwtResponse(userDetails.getUsername(),token,userDetails.getAuthorities()));

    }

    private Authentication authenticate(String userName, String password) throws Exception {
        try {
            return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName,password));
        }catch (DisabledException e){
            throw new Exception("User diabled");
        }catch (BadCredentialsException e){
            throw new Exception("Invalid credentials");
        }
    }


}
