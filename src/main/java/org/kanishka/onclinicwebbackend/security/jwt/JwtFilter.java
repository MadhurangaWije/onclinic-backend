package org.kanishka.onclinicwebbackend.security.jwt;


import org.kanishka.onclinicwebbackend.security.service.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtProvider jwtProvider;

    @Autowired
    UserDetailsServiceImpl userDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        try {
            String token = getJwt(request);
            if (token != null && jwtProvider.validateToken(token)) {
                String userName = jwtProvider.getUserNameFromJwtToken(token);
                UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));

                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }catch (Exception e){
            System.out.println("Cannot set user authentication");
        }

        filterChain.doFilter(request, response);
    }

    private String getJwt(HttpServletRequest request){
        String authHeader=request.getHeader("Authorization");
        if (authHeader!=null && authHeader.startsWith("Bearer ")){
            return authHeader.replace("Bearer ","");
        }
        return null;

    }
}
