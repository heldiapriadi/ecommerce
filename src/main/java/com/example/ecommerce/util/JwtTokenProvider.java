package com.example.ecommerce.util;

import com.example.ecommerce.model.UserCustomer;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JwtTokenProvider {
    @Value("${app.jwt-secret}")
    private String secretKey;

    @Value("${app.jwt-expiration-ms}")
    private long jwtExpirationInMs;

    public String generateToken(Authentication authentication) {
        UserCustomer userCustomer = (UserCustomer) authentication.getPrincipal();
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpirationInMs);

        HashMap<String, Object> claims = new HashMap<>();
        claims.put("email", userCustomer.getEmail());
        return Jwts.builder()
                .setSubject(Long.toString(userCustomer.getId()))
                .setClaims(claims)
                .setIssuedAt(new Date())
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, secretKey)
                .compact();
    }

    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return Long.parseLong(claims.getSubject());
    }

    public boolean validateToken(String authToken) {
        try {
            Jwts.parser().setSigningKey(secretKey).parseClaimsJws(authToken);
            return true;
        } catch (SignatureException ex) {
            //Invalid signature/claims
            return false;
        } catch (ExpiredJwtException ex) {
            //Expired token
            return false;
        } catch (UnsupportedJwtException ex) {
            //Unsupported JWT token
            return false;
        } catch (IllegalArgumentException ex) {
            //JWT claims string is empty
            return false;
        }
    }

    public String getCustomerId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }

    public String getEmail(String token){
        Claims claims = Jwts.parser()
                .setSigningKey(secretKey)
                .parseClaimsJws(token)
                .getBody();
        return (String) claims.get("email");
    }
}
