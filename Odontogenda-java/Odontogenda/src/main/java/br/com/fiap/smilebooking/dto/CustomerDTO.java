package br.com.fiap.smilebooking.dto;

import br.com.fiap.smilebooking.models.Address;
import br.com.fiap.smilebooking.models.Appointment;
import br.com.fiap.smilebooking.models.Contact;
import br.com.fiap.smilebooking.models.Customer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

public record CustomerDTO(UUID id, String name, String lastName, String email, LocalDate birthDate, String password,
                          Set<AppointmentDTO> appointmentDTOs, AddressDTO addressDTO,
                          Set<ContactDTO> contactDTOs) implements Serializable {
    public Customer toEntity() {
        Set<Appointment> appointments = this.appointmentDTOs.stream().map(AppointmentDTO::toEntity).collect(Collectors.toSet());
        Set<Contact> contacts = this.contactDTOs.stream().map(ContactDTO::toEntity).collect(Collectors.toSet());
        Address address = addressDTO().toEntity();
        Customer customer = new Customer();
        customer.setId(this.id);
        customer.setName(this.name);
        customer.setLastName(this.lastName);
        customer.setBirthDate(this.birthDate);
        customer.setPassword(this.password);
        customer.setEmail(this.email);
        customer.setContacts(contacts);
        customer.setAddress(address);
        customer.setAppointments(appointments);
        return customer;
    }
}