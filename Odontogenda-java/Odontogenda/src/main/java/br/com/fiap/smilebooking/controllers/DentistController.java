package br.com.fiap.smilebooking.controllers;

import br.com.fiap.smilebooking.dto.CreatedDTO;
import br.com.fiap.smilebooking.dto.DentistDTO;
import br.com.fiap.smilebooking.services.DentistService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dentists")
public class DentistController {

    private final DentistService service;

    public DentistController(DentistService dentistService) {
        this.service = dentistService;
    }

    @GetMapping
    public ResponseEntity<List<DentistDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DentistDTO> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<CreatedDTO> create(@RequestBody DentistDTO payload) {
        DentistDTO dentist = service.add(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedDTO(dentist.getId()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") String id, @RequestBody DentistDTO payload) {
        service.update(id, payload);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
