package br.com.fiap.smilebooking.models;

import br.com.fiap.smilebooking.dto.AddressDTO;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "addresses")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false, length = 10)
    private String number;

    @Column(nullable = false)
    private String street;

    @Column(nullable = false, length = 100)
    private String city;

    @Column(nullable = false, length = 50)
    private String neighbourhood;

    @Column(nullable = false, length = 100)
    private String country;

    public AddressDTO toDto() {
        return new AddressDTO(this.id, this.number, this.street, this.city, this.neighbourhood, this.country);
    }
}