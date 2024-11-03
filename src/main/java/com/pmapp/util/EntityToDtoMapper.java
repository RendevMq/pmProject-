package com.pmapp.util;

import com.pmapp.persistence.entity.*;
import com.pmapp.presentation.dto.*;

public class EntityToDtoMapper {

    // Convierte de BusEntity a BusDTO
    public static BusDTO toBusDTO(BusEntity busEntity) {
        return BusDTO.builder()
                .codigo(busEntity.getCodigo())
                .capacidad(busEntity.getCapacidad())
                .estado(busEntity.getEstado())
                .build();
    }

    // Convierte de EstacionEntity a EstacionDTO
    public static EstacionDTO toEstacionDTO(EstacionEntity estacionEntity) {
        return EstacionDTO.builder()
                .codigo(estacionEntity.getCodigo())
                .nombre(estacionEntity.getNombre())
                .direccion(estacionEntity.getDireccion())
                .estado(estacionEntity.getEstado())
                .build();
    }

    // Convierte de RutaEntity a RutaDTO
    public static RutaDTO toRutaDTO(RutaEntity rutaEntity) {
        return RutaDTO.builder()
                .codigo(rutaEntity.getCodigo())
                .nombre(rutaEntity.getNombre())
                .descripcion(rutaEntity.getDescripcion())
                .initialHour(rutaEntity.getInitialHour())
                .finalHour(rutaEntity.getFinalHour())
                .build();
    }

    // Convierte de EstacionRutaEntity a EstacionRutaDTO
    public static EstacionRutaDTO toEstacionRutaDTO(EstacionRutaEntity estacionRutaEntity) {
        return EstacionRutaDTO.builder()
                .id(estacionRutaEntity.getId())
                .estacion(toEstacionDTO(estacionRutaEntity.getEstacion()))
                .ruta(toRutaDTO(estacionRutaEntity.getRuta()))
                .numeroPasajeros(estacionRutaEntity.getNumeroPasajeros())
                .build();
    }

    // Convierte de CronogramaBusEntity a CronogramaBusDTO
    public static CronogramaBusDTO toCronogramaBusDTO(CronogramaBusEntity cronogramaBusEntity) {
        return CronogramaBusDTO.builder()
                .id(cronogramaBusEntity.getId())
                .bus(toBusDTO(cronogramaBusEntity.getBus()))
                .estacionRuta(toEstacionRutaDTO(cronogramaBusEntity.getEstacionRuta()))
                .horaSalida(cronogramaBusEntity.getHoraSalida())
                .horaLlegada(cronogramaBusEntity.getHoraLlegada())
                .build();
    }

    // Convierte de DemandaEstacionEntity a DemandaEstacionDTO
    public static DemandaEstacionDTO toDemandaEstacionDTO(DemandaEstacionEntity demandaEstacionEntity) {
        return DemandaEstacionDTO.builder()
                .id(demandaEstacionEntity.getId())
                .estacionRuta(toEstacionRutaDTO(demandaEstacionEntity.getEstacionRuta()))
                .numeroPasajeros(demandaEstacionEntity.getNumeroPasajeros())
                .hora(demandaEstacionEntity.getHora())
                .dia(demandaEstacionEntity.getDia())
                .clima(demandaEstacionEntity.getClima())
                .eventoEspecial(demandaEstacionEntity.getEventoEspecial())
                .build();
    }
}
