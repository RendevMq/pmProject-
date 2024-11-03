package com.pmapp.service.implementation;

import com.pmapp.persistence.entity.DemandaEstacionEntity;
import com.pmapp.persistence.repository.DemandaEstacionRepository;
import com.pmapp.presentation.dto.DemandaEstacionDTO;
import com.pmapp.service.exception.ResourceNotFoundException;
import com.pmapp.service.interfaces.IDemandaEstacionService;
import com.pmapp.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class DemandaEstacionServiceImpl implements IDemandaEstacionService {

    @Autowired
    private DemandaEstacionRepository demandaEstacionRepository;

    @Override
    public List<DemandaEstacionDTO> getAllDemandas() {
        List<DemandaEstacionEntity> demandas = (List<DemandaEstacionEntity>) demandaEstacionRepository.findAll();
        return demandas.stream().map(EntityToDtoMapper::toDemandaEstacionDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<DemandaEstacionDTO> getDemandaById(Long id) {
        DemandaEstacionEntity demandaEstacionEntity = demandaEstacionRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Demanda no encontrada con ID: " + id));
        return Optional.of(EntityToDtoMapper.toDemandaEstacionDTO(demandaEstacionEntity));
    }
}
