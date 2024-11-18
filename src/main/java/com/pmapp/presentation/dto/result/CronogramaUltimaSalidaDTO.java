package com.pmapp.presentation.dto.result;

import java.time.LocalDateTime;

public interface CronogramaUltimaSalidaDTO {
    String getCodigoBus();
    String getEstacion();
    String getRuta();
    LocalDateTime getHoraSalida();
}
