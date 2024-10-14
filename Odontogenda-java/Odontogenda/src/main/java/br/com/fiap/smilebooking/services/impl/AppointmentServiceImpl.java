package br.com.fiap.smilebooking.services.impl;

import br.com.fiap.smilebooking.dto.AppointmentDTO;
import br.com.fiap.smilebooking.models.Appointment;
import br.com.fiap.smilebooking.repositories.AppointmentRepository;
import br.com.fiap.smilebooking.services.AppointmentService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class AppointmentServiceImpl implements AppointmentService {

    private final AppointmentRepository repository;

    public AppointmentServiceImpl(AppointmentRepository repository) {
        this.repository = repository;
    }

    @Override
    public AppointmentDTO create(AppointmentDTO dto) {
        Appointment appointment = dto.toEntity();
        return repository.save(appointment).toDto();
    }

    @Override
    public void cancel(String id) {
        repository.deleteById(UUID.fromString(id));
    }
}
