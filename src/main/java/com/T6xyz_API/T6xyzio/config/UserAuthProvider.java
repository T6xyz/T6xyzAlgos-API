package com.T6xyz_API.T6xyzio.config;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.T6xyz_API.T6xyzio.enums.Roles;
import com.T6xyz_API.T6xyzio.users.UserDTO;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class UserAuthProvider {
    
    @Value("${security.jwt.token.secret-key:secret-key}")
    private String secretKey;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    public String createToken(UserDTO userDTO) {
        Date curr = new Date();
        Date valid = new Date(curr.getTime() + 3600000);
        
        return JWT.create()
                .withIssuer(userDTO.getUsername())
                .withIssuedAt(curr)
                .withExpiresAt(valid)
                .withClaim("isPremium", userDTO.getIsPremium())
                .withClaim("role", userDTO.getRole().name())
                .sign(Algorithm.HMAC256(this.secretKey));
    }
 
    public Authentication validateJWT(String token) {
        Algorithm algo = Algorithm.HMAC256(this.secretKey);

        JWTVerifier verifier = JWT.require(algo).build();

        DecodedJWT decoded = verifier.verify(token);

        UserDTO user = UserDTO.builder()
                .username(decoded.getIssuer())
                .isPremium(decoded.getClaim("isPremium").asBoolean())
                .role(Roles.valueOf(decoded.getClaim("role").asString()))
                .build();

        return new UsernamePasswordAuthenticationToken(user, null, Arrays.asList(user.getRole()));
    }
}