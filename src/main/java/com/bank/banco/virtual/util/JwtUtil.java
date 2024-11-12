package com.bank.banco.virtual.util;
import com.bank.banco.virtual.JwtProperties;
import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
@Component
public class JwtUtil {
    @Autowired
    private JwtProperties jwtProperties;

    // Gera o token JWT
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + jwtProperties.getExpiration()))
                .signWith(SignatureAlgorithm.HS512, jwtProperties.getSecret())
                .compact();
    }

    // Valida o token JWT
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtProperties.getSecret()).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    // Obtém o username do token JWT
    public String getUsernameFromToken(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtProperties.getSecret())
                .parseClaimsJws(token)
                .getBody();
        return claims.getSubject();
    }
}
