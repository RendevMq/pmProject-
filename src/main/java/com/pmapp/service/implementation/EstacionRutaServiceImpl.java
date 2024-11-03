package com.pmapp.service.implementation;

import com.pmapp.persistence.entity.EstacionRutaEntity;
import com.pmapp.persistence.repository.EstacionRutaRepository;
import com.pmapp.presentation.dto.EstacionRutaDTO;
import com.pmapp.presentation.dto.result.DemandaEstacionRutaDto;
import com.pmapp.service.exception.ResourceNotFoundException;
import com.pmapp.service.interfaces.IEstacionRutaService;
import com.pmapp.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class EstacionRutaServiceImpl implements IEstacionRutaService {

    @Autowired
    private EstacionRutaRepository estacionRutaRepository;

    @Override
    public List<EstacionRutaDTO> getAllEstacionRutas() {
        List<EstacionRutaEntity> estacionRutas = (List<EstacionRutaEntity>) estacionRutaRepository.findAll();
        return estacionRutas.stream().map(EntityToDtoMapper::toEstacionRutaDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<EstacionRutaDTO> getEstacionRutaById(Long id) {
        EstacionRutaEntity estacionRutaEntity = estacionRutaRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estación-Ruta no encontrada con ID: " + id));
        return Optional.of(EntityToDtoMapper.toEstacionRutaDTO(estacionRutaEntity));
    }

    @Override
    public List<DemandaEstacionRutaDto> getDemandaEstacionRuta() {
        return estacionRutaRepository.findDemandaEstacionRuta();
    }
}
