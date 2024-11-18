package com.pmapp.service.implementation;

import com.pmapp.persistence.entity.CronogramaBusEntity;
import com.pmapp.persistence.repository.CronogramaBusRepository;
import com.pmapp.presentation.dto.CronogramaBusDTO;
import com.pmapp.presentation.dto.result.CronogramaBusQueryDto;
import com.pmapp.presentation.dto.result.CronogramaUltimaSalidaDTO;
import com.pmapp.service.exception.ResourceNotFoundException;
import com.pmapp.service.interfaces.ICronogramaBusService;
import com.pmapp.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CronogramaBusServiceImpl implements ICronogramaBusService {

    @Autowired
    private CronogramaBusRepository cronogramaBusRepository;

    @Override
    public List<CronogramaBusDTO> getAllCronogramas() {
        List<CronogramaBusEntity> cronogramas = (List<CronogramaBusEntity>) cronogramaBusRepository.findAll();
        return cronogramas.stream().map(EntityToDtoMapper::toCronogramaBusDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<CronogramaBusDTO> getCronogramaById(Long id) {
        CronogramaBusEntity cronogramaBusEntity = cronogramaBusRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Cronograma no encontrado con ID: " + id));
        return Optional.of(EntityToDtoMapper.toCronogramaBusDTO(cronogramaBusEntity));
    }

    @Override
    public List<CronogramaBusQueryDto> getCronogramaBusDetails() {
        return cronogramaBusRepository.findCronogramaBusDetails();
    }

    @Override
    public List<CronogramaUltimaSalidaDTO> getCronogramaUltimaSalida() {
        return cronogramaBusRepository.findCronogramaUltimaSalida();
    }

}
