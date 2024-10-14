package br.com.fiap.smilebooking.controllers;


import br.com.fiap.smilebooking.dto.AppointmentDTO;
import br.com.fiap.smilebooking.dto.CreatedDTO;
import br.com.fiap.smilebooking.services.AppointmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/appointments")
public class AppointmentController {

    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.cancel(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<CreatedDTO> create(@RequestBody AppointmentDTO appointmentDTO) {
        service.create(appointmentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedDTO(appointmentDTO.id()));
    }
}
