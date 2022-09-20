package com.devsuperior.dslearnbds.services;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.auth0.jwt.interfaces.Payload;
import com.devsuperior.dslearnbds.entities.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.function.Function;

@Component
public class JwtUtil {

    private static final long EXPIRE_DURATION = 24 * 60 * 60 * 1000; // 24 hour
    @Value("${app.jwt.secret}")
    private String SECRET_KEY;

    public String generateAccessToken(User user) {
        return JWT.create()
                .withSubject(user.getUsername())
                .withClaim("id", user.getId())
                .withExpiresAt(Instant.now().plusMillis(EXPIRE_DURATION * 7))
                .sign(Algorithm.HMAC512(SECRET_KEY));

    }

    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = this.getSubject(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    private boolean isTokenExpired(String token) {
        Instant ins = this.getExpiresAt(token);
        return Instant.now().isAfter(ins);
    }

    public Instant getExpiresAt(String token){
        return this.extractClaimFromToken(token, Payload::getExpiresAtAsInstant);
    }

    public String getSubject(String token){
        return this.extractClaimFromToken(token, Payload::getSubject);
    }
    private <T> T extractClaimFromToken(String token, Function<DecodedJWT, T> resolver){
        DecodedJWT decodedJWT = this.extractClaimsFromToken(token);
        return resolver.apply(decodedJWT);
    }

    private DecodedJWT extractClaimsFromToken(String token){
        return JWT.require(Algorithm.HMAC512(SECRET_KEY))
                .build()
                .verify(token);
    }
}
