package com.pmapp.presentation.dto.result;

import java.time.LocalDateTime;

public interface CronogramaBusQueryDto {
    String getCodigoBus();
    String getEstacion();
    String getRuta();
    LocalDateTime getHoraSalida();
}