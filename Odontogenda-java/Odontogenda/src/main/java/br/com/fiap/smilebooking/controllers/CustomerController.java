package br.com.fiap.smilebooking.controllers;

import br.com.fiap.smilebooking.dto.AppointmentDTO;
import br.com.fiap.smilebooking.dto.CreatedDTO;
import br.com.fiap.smilebooking.dto.CustomerDTO;
import br.com.fiap.smilebooking.dto.DentistDTO;
import br.com.fiap.smilebooking.services.AppointmentService;
import br.com.fiap.smilebooking.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService service;
    private final AppointmentService appointmentService;

    public CustomerController(CustomerService customerService, AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
        this.service = customerService;
    }

    @GetMapping
    public ResponseEntity<List<CustomerDTO>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerDTO> get(@PathVariable("id") String id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PostMapping
    public ResponseEntity<CreatedDTO> create(@RequestBody CustomerDTO payload) {
        CustomerDTO customer = service.add(payload);
        return ResponseEntity.status(HttpStatus.CREATED).body(new CreatedDTO(customer.id()));
    }


    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable("id") String id, @RequestBody CustomerDTO payload) {
        service.update(id, payload);
        return ResponseEntity.accepted().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") String id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }
}
