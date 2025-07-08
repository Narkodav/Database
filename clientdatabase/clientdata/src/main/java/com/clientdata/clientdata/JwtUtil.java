package com.clientdata.clientdata;

import io.jsonwebtoken.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtUtil {
    @Value("${jwt.public-key}")
    private String PUBLIC_KEY;

    private PublicKey getVerifyingKey() {
        try {
            String publicKeyPEM = PUBLIC_KEY
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");
            
            byte[] decoded = Base64.getDecoder().decode(publicKeyPEM);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(decoded);
            KeyFactory factory = KeyFactory.getInstance("RSA");
            return factory.generatePublic(spec);
        } catch (Exception e) {
            throw new RuntimeException("Failed to load public key", e);
        }
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public boolean isTokenValid(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token);
    }

    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date());
    }

    private Claims extractClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getVerifyingKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}