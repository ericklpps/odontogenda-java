package br.com.fiap.smilebooking.dto;

import br.com.fiap.smilebooking.models.Address;
import br.com.fiap.smilebooking.models.Appointment;
import br.com.fiap.smilebooking.models.Contact;
import br.com.fiap.smilebooking.models.Dentist;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DentistDTO implements Serializable {
    private UUID id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthDate;
    private String password;
    private AddressDTO addressDTO;
    private Set<ContactDTO> contactDTOs;
    private Set<AppointmentDTO> appointmentDTOs;

    public Dentist toEntity() {
        Set<Appointment> appointments = this.appointmentDTOs.stream().map(AppointmentDTO::toEntity).collect(Collectors.toSet());
        Set<Contact> contacts = this.contactDTOs.stream().map(ContactDTO::toEntity).collect(Collectors.toSet());
        Address address = this.addressDTO.toEntity();

        Dentist dentist = new Dentist();
        dentist.setId(this.id);
        dentist.setName(this.name);
        dentist.setLastName(this.lastName);
        dentist.setEmail(this.email);
        dentist.setPassword(this.password);
        dentist.setBirthDate(this.birthDate);
        dentist.setAppointments(appointments);
        dentist.setContacts(contacts);
        dentist.setAddress(address);
        return dentist;
    }
}