package com.credibanco.loginback.auth.infrastructure.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;


import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.function.Function;

@Component
public class JwtUtils {

    private final static String ACCES_TOKEN_SECRET = "154E29F9B4D825F28C8F93586BC1DCBA75D379FE5F17822D5783D338FB";
    private final static Long ACCES_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken( String email) {
        long expirationtime = ACCES_TOKEN_VALIDITY_SECONDS * 1000;
        Date espirationDate = new Date(System.currentTimeMillis() + expirationtime);

        Map<String, Object> extra = new HashMap<>();
        extra.put("email", email);

        return Jwts.builder()
                .setSubject(email)
                .setExpiration(espirationDate)
                .addClaims(extra)
                .signWith(Keys.hmacShaKeyFor(ACCES_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(ACCES_TOKEN_SECRET.getBytes())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();

            String email = claims.getSubject();

            return new UsernamePasswordAuthenticationToken(email, null, Collections.emptyList());
        }catch (JwtException e) {
            return null;
        }
    }
}








