package kr.co.rland.rland_boot3_api.auth.util;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.List;

public class JwtUtil {

    private final Key secretKdy;

    public JwtUtil(@Value("rland.jwt.secret") String secret) {
        byte[] keyBytes = Decoders.BASE64.decode(secret);
        this.secretKdy = Keys.hmacShaKeyFor(keyBytes);
    }

    public boolean validateToken(String token) {
        return true;
    }

    public String extractUsername(String token) {
        return null;
    }

    public List<String> extractRoles(String token) {
        return null;
    }
}
