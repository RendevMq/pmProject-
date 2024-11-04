package com.pmapp.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;
@Component
public class JwtUtils {

    @Value("${security.jwt.key.private}")
    private String privateKey;

    @Value("${security.jwt.user.generator}")
    private String userGenerator;

    // METODO para crear un token con el rol del usuario
    public String createToken(Authentication authentication) {
        Algorithm algorithm = Algorithm.HMAC256(this.privateKey);

        // Cambiamos "username" a "email" para usarlo como el identificador principal
        String email = authentication.getPrincipal().toString();

        // Obtenemos solo los roles en lugar de permisos o autoridades
        String roles = authentication.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(",")); // Ejemplo: "ROLE_USER,ROLE_ADMIN"

        // Generamos el token
        return JWT.create()
                .withIssuer(this.userGenerator)
                .withSubject(email)  // Cambiamos para usar email como subject
                .withClaim("roles", roles)  // Cambiamos "authorities" a "roles"
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + 1800000))
                .withJWTId(UUID.randomUUID().toString())
                .withNotBefore(new Date(System.currentTimeMillis()))
                .sign(algorithm); // Firma el token
    }

    // Validación del token
    public DecodedJWT validateToken(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC256(this.privateKey);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(this.userGenerator)
                    .build();

            return verifier.verify(token);
        } catch (JWTVerificationException exception) {
            throw new JWTVerificationException("Token inválido");
        }
    }

    // Cambiamos el nombre del método a extractEmail para reflejar el uso de email en lugar de username
    public String extractEmail(DecodedJWT decodedJWT) {
        return decodedJWT.getSubject();  // Ahora el subject es el email
    }

    // Método para obtener los roles desde el token
    public Claim getRoles(DecodedJWT decodedJWT) {
        return decodedJWT.getClaim("roles"); // Ahora obtenemos los roles
    }

    // Método para devolver todos los claims
    public Map<String, Claim> returnAllClaims(DecodedJWT decodedJWT) {
        return decodedJWT.getClaims();
    }
}

