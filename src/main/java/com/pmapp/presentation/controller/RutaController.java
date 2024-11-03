package com.pmapp.presentation.controller;

import com.pmapp.presentation.dto.RutaDTO;
import com.pmapp.service.interfaces.IRutaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/rutas")
@Validated
public class RutaController {

    @Autowired
    private IRutaService rutaService;

    @GetMapping
    public ResponseEntity<List<RutaDTO>> getAllRutas() {
        List<RutaDTO> rutas = rutaService.getAllRutas();
        return ResponseEntity.ok(rutas);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<RutaDTO> getRutaByCodigo(@PathVariable String codigo) {
        Optional<RutaDTO> ruta = rutaService.getRutaByCodigo(codigo);
        return ruta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<RutaDTO> createRuta(@Valid @RequestBody RutaDTO rutaDTO) {
        // Lógica para crear la ruta
        return ResponseEntity.status(201).body(rutaDTO);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<RutaDTO> updateRuta(@PathVariable String codigo, @Valid @RequestBody RutaDTO rutaDTO) {
        // Lógica para actualizar la ruta
        return ResponseEntity.ok(rutaDTO);
    }
}
