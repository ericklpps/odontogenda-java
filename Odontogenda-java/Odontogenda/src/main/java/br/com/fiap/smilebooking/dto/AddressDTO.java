package br.com.fiap.smilebooking.dto;

import br.com.fiap.smilebooking.models.Address;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AddressDTO implements Serializable {
    private UUID id;
    private String number;
    private String street;
    private String city;
    private String neighbourhood;
    private String country;

    public Address toEntity() {
        Address address = new Address();
        address.setCity(this.city);
        address.setId(this.id);
        address.setCountry(this.country);
        address.setStreet(this.street);
        address.setNumber(this.number);
        address.setNeighbourhood(this.neighbourhood);
        return address;
    }
}