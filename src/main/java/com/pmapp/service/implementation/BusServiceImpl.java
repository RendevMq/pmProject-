package com.pmapp.service.implementation;

import com.pmapp.persistence.entity.BusEntity;
import com.pmapp.persistence.repository.BusRepository;
import com.pmapp.presentation.dto.BusDTO;
import com.pmapp.service.exception.ResourceNotFoundException;
import com.pmapp.service.interfaces.IBusService;
import com.pmapp.util.EntityToDtoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BusServiceImpl implements IBusService {

    @Autowired
    private BusRepository busRepository;

    @Override
    public List<BusDTO> getAllBuses() {
        List<BusEntity> buses = (List<BusEntity>) busRepository.findAll();
        return buses.stream().map(EntityToDtoMapper::toBusDTO).collect(Collectors.toList());
    }

    @Override
    public Optional<BusDTO> getBusByCodigo(String codigo) {
        BusEntity busEntity = busRepository.findById(codigo)
                .orElseThrow(() -> new ResourceNotFoundException("Bus no encontrado con código: " + codigo));
        return Optional.of(EntityToDtoMapper.toBusDTO(busEntity));
    }
}
