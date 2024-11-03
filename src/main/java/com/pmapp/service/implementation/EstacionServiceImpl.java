package com.pmapp.service.implementation;

import com.pmapp.persistence.entity.EstacionEntity;
import com.pmapp.persistence.repository.EstacionRepository;
import com.pmapp.presentation.dto.EstacionDTO;
import com.pmapp.service.exception.ResourceNotFoundException;
import com.pmapp.service.interfaces.IEstacionService;
import com.pmapp.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstacionServiceImpl implements IEstacionService {

    @Autowired
    private EstacionRepository estacionRepository;

    @Override
    public List<EstacionDTO> getAllEstaciones() {
        List<EstacionEntity> estaciones = (List<EstacionEntity>) estacionRepository.findAll();
        return estaciones.stream().map(EntityToDtoMapper::toEstacionDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<EstacionDTO> getEstacionByCodigo(String codigo) {
        EstacionEntity estacionEntity = estacionRepository.findById(codigo)
                .orElseThrow(() -> new ResourceNotFoundException("Estación no encontrada con código: " + codigo));
        return Optional.of(EntityToDtoMapper.toEstacionDTO(estacionEntity));
    }
}
