package br.com.fiap.smilebooking.dto;

import br.com.fiap.smilebooking.models.Appointment;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

public record AppointmentDTO(UUID id, LocalDate date, LocalDateTime entryTime, LocalDateTime estimatedExitTime) implements Serializable {
  public Appointment toEntity() {
    return Appointment.builder()
            .date(this.date)
            .entryTime(this.entryTime)
            .estimatedExitTime(this.estimatedExitTime)
            .build();
  }
}