package com.pmapp.presentation.controller;


import com.pmapp.presentation.dto.EstacionDTO;
import com.pmapp.service.interfaces.IEstacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estaciones")
@Validated
public class EstacionController {

    @Autowired
    private IEstacionService estacionService;

    @GetMapping
    public ResponseEntity<List<EstacionDTO>> getAllEstaciones() {
        List<EstacionDTO> estaciones = estacionService.getAllEstaciones();
        return ResponseEntity.ok(estaciones);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<EstacionDTO> getEstacionByCodigo(@PathVariable String codigo) {
        Optional<EstacionDTO> estacion = estacionService.getEstacionByCodigo(codigo);
        return estacion.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstacionDTO> createEstacion(@Valid @RequestBody EstacionDTO estacionDTO) {
        // Lógica para crear la estación
        return ResponseEntity.status(201).body(estacionDTO);
    }

    @PutMapping("/{codigo}")
    public ResponseEntity<EstacionDTO> updateEstacion(@PathVariable String codigo, @Valid @RequestBody EstacionDTO estacionDTO) {
        // Lógica para actualizar la estación
        return ResponseEntity.ok(estacionDTO);
    }
}
