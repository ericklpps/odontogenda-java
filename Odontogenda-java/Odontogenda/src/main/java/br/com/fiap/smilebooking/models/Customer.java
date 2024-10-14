package br.com.fiap.smilebooking.models;

import br.com.fiap.smilebooking.dto.AddressDTO;
import br.com.fiap.smilebooking.dto.AppointmentDTO;
import br.com.fiap.smilebooking.dto.ContactDTO;
import br.com.fiap.smilebooking.dto.CustomerDTO;
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
@Table(name = "customers")
public class Customer {
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

    @OneToMany(mappedBy = "customer", orphanRemoval = true)
    private Set<Appointment> appointments = new LinkedHashSet<>();

    @OneToOne(optional = false, orphanRemoval = true)
    @JoinColumn(name = "address_id", nullable = false)
    private Address address;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "customer_id", nullable = false, unique = true)
    private Set<Contact> contacts = new LinkedHashSet<>();

    public CustomerDTO toDTO() {
        AddressDTO addressDTO = this.getAddress().toDto();
        Set<ContactDTO> contactDTOs = this.getContacts().stream().map(Contact::toDTO).collect(Collectors.toSet());
        Set<AppointmentDTO> appointmentDTOs = this.getAppointments().stream().map(Appointment::toDto).collect(Collectors.toSet());
        return new CustomerDTO(this.id, this.name, this.lastName, this.email, this.birthDate, this.password, appointmentDTOs, addressDTO, contactDTOs);
    }
}