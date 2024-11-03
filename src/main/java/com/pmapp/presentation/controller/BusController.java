package com.pmapp.presentation.controller;

import com.pmapp.presentation.dto.BusDTO;
import com.pmapp.service.interfaces.IBusService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/buses")
@Validated
public class BusController {

    @Autowired
    private IBusService busService;

    @GetMapping
    public ResponseEntity<List<BusDTO>> getAllBuses() {
        List<BusDTO> buses = busService.getAllBuses();
        return ResponseEntity.ok(buses);
    }

    @GetMapping("/{codigo}")
    public ResponseEntity<BusDTO> getBusByCodigo(@PathVariable String codigo) {
        Optional<BusDTO> bus = busService.getBusByCodigo(codigo);
        return bus.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<BusDTO> createBus(@Valid @RequestBody BusDTO busDTO) {
        // Lógica para crear el bus
        return ResponseEntity.status(201).body(busDTO);
    }

    // Mas metodos...
}

