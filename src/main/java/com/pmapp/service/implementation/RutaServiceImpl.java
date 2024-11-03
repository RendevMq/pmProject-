package com.pmapp.service.implementation;

import com.pmapp.persistence.entity.RutaEntity;
import com.pmapp.persistence.repository.RutaRepository;
import com.pmapp.presentation.dto.RutaDTO;
import com.pmapp.service.exception.ResourceNotFoundException;
import com.pmapp.service.interfaces.IRutaService;
import com.pmapp.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RutaServiceImpl implements IRutaService {

    @Autowired
    private RutaRepository rutaRepository;

    @Override
    public List<RutaDTO> getAllRutas() {
        List<RutaEntity> rutas = (List<RutaEntity>) rutaRepository.findAll();
        return rutas.stream().map(EntityToDtoMapper::toRutaDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<RutaDTO> getRutaByCodigo(String codigo) {
        RutaEntity rutaEntity = rutaRepository.findById(codigo)
                .orElseThrow(() -> new ResourceNotFoundException("Ruta no encontrada con código: " + codigo));
        return Optional.of(EntityToDtoMapper.toRutaDTO(rutaEntity));
    }
}
