package br.com.fiap.smilebooking.models;

import br.com.fiap.smilebooking.dto.ContactDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "contacts")
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, unique = true)
    private String phoneNumber;

    public ContactDTO toDTO() {
        return new ContactDTO(this.id, this.phoneNumber);
    }
}