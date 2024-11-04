package com.pmapp.presentation.controller;

import com.auth0.jwt.exceptions.JWTVerificationException;
import com.pmapp.presentation.dto.authDto.AuthLoginRequest;
import com.pmapp.presentation.dto.authDto.AuthResponse;
import com.pmapp.service.implementation.UserDetailsServiceImpl;
import com.pmapp.util.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping("/log-in")
    public ResponseEntity<AuthResponse> login (@RequestBody @Valid AuthLoginRequest userRequest){
        return new ResponseEntity<>(this.userDetailsService.loginUser(userRequest), HttpStatus.OK);
    }


    @GetMapping("/validate")
    public ResponseEntity<Map<String, String>> validateToken(HttpServletRequest request) {
        String jwtToken = request.getHeader(HttpHeaders.AUTHORIZATION);

        Map<String, String> response = new HashMap<>();

        if (jwtToken != null && jwtToken.startsWith("Bearer ")) {
            jwtToken = jwtToken.substring(7); // Quitamos "Bearer " para obtener el token real

            try {
                jwtUtils.validateToken(jwtToken); // Valida el token
                response.put("message", "Token is valid");
                return ResponseEntity.ok(response); // Respuesta 200 OK con JSON si el token es válido
            } catch (JWTVerificationException e) {
                response.put("message", "Invalid or expired token");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response); // Respuesta 401 Unauthorized con JSON si el token es inválido
            }
        } else {
            response.put("message", "Authorization header missing or invalid");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }
    }


}