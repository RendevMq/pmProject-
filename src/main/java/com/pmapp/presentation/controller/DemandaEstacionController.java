package com.pmapp.presentation.controller;

import com.pmapp.presentation.dto.DemandaEstacionDTO;
import com.pmapp.service.interfaces.IDemandaEstacionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/demandas")
@Validated
public class DemandaEstacionController {

    @Autowired
    private IDemandaEstacionService demandaEstacionService;

    @GetMapping
    public ResponseEntity<List<DemandaEstacionDTO>> getAllDemandas() {
        List<DemandaEstacionDTO> demandas = demandaEstacionService.getAllDemandas();
        return ResponseEntity.ok(demandas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DemandaEstacionDTO> getDemandaById(@PathVariable Long id) {
        Optional<DemandaEstacionDTO> demanda = demandaEstacionService.getDemandaById(id);
        return demanda.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<DemandaEstacionDTO> createDemanda(@Valid @RequestBody DemandaEstacionDTO demandaEstacionDTO) {
        // Lógica para crear la demanda
        return ResponseEntity.status(201).body(demandaEstacionDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<DemandaEstacionDTO> updateDemanda(@PathVariable Long id, @Valid @RequestBody DemandaEstacionDTO demandaEstacionDTO) {
        // Lógica para actualizar la demanda
        return ResponseEntity.ok(demandaEstacionDTO);
    }
}
