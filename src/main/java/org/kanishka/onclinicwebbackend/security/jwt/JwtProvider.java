package org.kanishka.onclinicwebbackend.security.jwt;

import io.jsonwebtoken.*;
import org.kanishka.onclinicwebbackend.model.UserPrinciple;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Component
public class JwtProvider {

    @Value("${app.jwtSecret}")
    private String secret;

    @Value("${app.jwtExpiration}")
    private int expiration;


    public String generateToken(Authentication authentication){
        UserDetails userDetails=(UserPrinciple) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setExpiration(new Date(new Date().getTime()+expiration*1000))
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS512,secret)
                .compact();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (SignatureException e){
            System.out.printf("Invalid JWT Signature. Message -> "+e.getMessage());
        }catch (MalformedJwtException e){
            System.out.println("Malformed JWT token. Message ->"+e.getMessage());
        }catch (ExpiredJwtException e){
            System.out.println("Expired JWT token. Message ->"+e.getMessage());
        }catch (UnsupportedJwtException e){
            System.out.println("Unsupported JWT token. Message ->"+e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("JWT Claims String is empty ->"+e.getMessage());
        }

        return false;

    }

    public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public String geExpirationFromJwtToken(String token){
        Date d=Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getExpiration();
        LocalDateTime localDateTime=d.toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
        return localDateTime.toString();
    }
}
