package com.pmapp.presentation.controller;

import com.pmapp.presentation.dto.CronogramaBusDTO;
import com.pmapp.presentation.dto.result.CronogramaBusQueryDto;
import com.pmapp.service.interfaces.ICronogramaBusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cronogramas")
@Validated
public class CronogramaBusController {

    @Autowired
    private ICronogramaBusService cronogramaBusService;

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping
    public ResponseEntity<List<CronogramaBusDTO>> getAllCronogramas() {
        List<CronogramaBusDTO> cronogramas = cronogramaBusService.getAllCronogramas();
        return ResponseEntity.ok(cronogramas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CronogramaBusDTO> getCronogramaById(@PathVariable Long id) {
        Optional<CronogramaBusDTO> cronograma = cronogramaBusService.getCronogramaById(id);
        return cronograma.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<CronogramaBusDTO> createCronograma(@Valid @RequestBody CronogramaBusDTO cronogramaBusDTO) {
        // Lógica para crear el cronograma
        return ResponseEntity.status(201).body(cronogramaBusDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CronogramaBusDTO> updateCronograma(@PathVariable Long id, @Valid @RequestBody CronogramaBusDTO cronogramaBusDTO) {
        // Lógica para actualizar el cronograma
        return ResponseEntity.ok(cronogramaBusDTO);
    }

    @GetMapping("/detalle")
    public List<CronogramaBusQueryDto> obtenerDetalleCronograma() {
        return cronogramaBusService.getCronogramaBusDetails();
    }
}
