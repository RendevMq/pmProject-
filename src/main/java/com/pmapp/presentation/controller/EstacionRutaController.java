package com.pmapp.presentation.controller;

import com.pmapp.presentation.dto.EstacionRutaDTO;
import com.pmapp.presentation.dto.result.DemandaEstacionRutaDto;
import com.pmapp.service.interfaces.IEstacionRutaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/estaciones-rutas")
@Validated
public class EstacionRutaController {

    @Autowired
    private IEstacionRutaService estacionRutaService;

    @GetMapping
    public ResponseEntity<List<EstacionRutaDTO>> getAllEstacionRutas() {
        List<EstacionRutaDTO> estacionRutas = estacionRutaService.getAllEstacionRutas();
        return ResponseEntity.ok(estacionRutas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EstacionRutaDTO> getEstacionRutaById(@PathVariable Long id) {
        Optional<EstacionRutaDTO> estacionRuta = estacionRutaService.getEstacionRutaById(id);
        return estacionRuta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<EstacionRutaDTO> createEstacionRuta(@Valid @RequestBody EstacionRutaDTO estacionRutaDTO) {
        // Lógica para crear la relación estación-ruta
        return ResponseEntity.status(201).body(estacionRutaDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EstacionRutaDTO> updateEstacionRuta(@PathVariable Long id, @Valid @RequestBody EstacionRutaDTO estacionRutaDTO) {
        // Lógica para actualizar la relación estación-ruta
        return ResponseEntity.ok(estacionRutaDTO);
    }

    @GetMapping("/demanda")
    public ResponseEntity<List<DemandaEstacionRutaDto>> getDemandaEstacionRuta() {
        List<DemandaEstacionRutaDto> demandaEstacionRuta = estacionRutaService.getDemandaEstacionRuta();
        return ResponseEntity.ok(demandaEstacionRuta);
    }

}
