package br.com.fiap.smilebooking.models;

import br.com.fiap.smilebooking.dto.AddressDTO;
import br.com.fiap.smilebooking.dto.AppointmentDTO;
import br.com.fiap.smilebooking.dto.ContactDTO;
import br.com.fiap.smilebooking.dto.DentistDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.UUID;
import java.util.stream.Collectors;

@Getter
@Setter
@Entity
@Table(name = "dentists")
public class Dentist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column(unique = true)
    private String email;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private String password;

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(mappedBy = "dentist", orphanRemoval = true)
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "dentist_id", nullable = false, unique = true)
    private Set<Contact> contacts = new LinkedHashSet<>();

    public DentistDTO toDTO() {
        AddressDTO addressDTO = this.getAddress().toDto();
        Set<ContactDTO> contactDTOs = this.getContacts().stream().map(Contact::toDTO).collect(Collectors.toSet());
        Set<AppointmentDTO> appointmentDTOs = this.getAppointments().stream().map(Appointment::toDto).collect(Collectors.toSet());

        return new DentistDTO(this.getId(), this.getName(), this.getLastName(),
                this.getEmail(), this.getBirthDate(), this.getPassword(), addressDTO, contactDTOs, appointmentDTOs);
    }
}