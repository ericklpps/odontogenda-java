package br.com.fiap.smilebooking.services.impl;

import br.com.fiap.smilebooking.dto.DentistDTO;
import br.com.fiap.smilebooking.exception.DentistNotFoundException;
import br.com.fiap.smilebooking.models.Dentist;
import br.com.fiap.smilebooking.repositories.DentistRepository;
import br.com.fiap.smilebooking.services.DentistService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DentistServiceImpl implements DentistService {

    private final DentistRepository repository;

    public DentistServiceImpl(DentistRepository repository) {
        this.repository = repository;
    }

    @Override
    public DentistDTO add(DentistDTO dentist) {
        Dentist newDentist = repository.save(dentist.toEntity());
        return newDentist.toDTO();
    }

    @Override
    public DentistDTO get(String id) {
        UUID uuid = UUID.fromString(id);
        Dentist dentist = repository.findById(uuid).orElseThrow(DentistNotFoundException::new);
        return dentist.toDTO();
    }

    @Override
    public List<DentistDTO> getAll() {
        return repository.findAll().stream().map(Dentist::toDTO).toList();
    }

    @Override
    public void delete(String id) {
        UUID uuid = UUID.fromString(id);
        if (!repository.existsById(uuid)) {
            throw new DentistNotFoundException();
        }
        repository.deleteById(uuid);
    }

    @Override
    public void update(String id, DentistDTO dentistDto) {
        UUID uuid = UUID.fromString(id);
        if (!repository.existsById(uuid)) {
            throw new DentistNotFoundException();
        }
        repository.save(dentistDto.toEntity());
    }
}
