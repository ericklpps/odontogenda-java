package br.com.fiap.smilebooking.services;

import br.com.fiap.smilebooking.dto.AppointmentDTO;

public interface AppointmentService {
    AppointmentDTO create(AppointmentDTO appointmentDto);
    void cancel(String id);
}
