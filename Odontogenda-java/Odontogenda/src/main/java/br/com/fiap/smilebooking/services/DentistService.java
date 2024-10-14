package br.com.fiap.smilebooking.services;

import br.com.fiap.smilebooking.dto.DentistDTO;

import java.util.List;

public interface DentistService {
    DentistDTO add(DentistDTO dentist);
    DentistDTO get(String id);
    List<DentistDTO> getAll();
    void delete(String id);
    void update(String id, DentistDTO dentistDto);
}
