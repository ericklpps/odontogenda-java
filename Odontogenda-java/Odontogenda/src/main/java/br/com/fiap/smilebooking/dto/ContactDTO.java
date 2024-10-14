package br.com.fiap.smilebooking.dto;

import br.com.fiap.smilebooking.models.Contact;

import java.io.Serializable;
import java.util.UUID;

public record ContactDTO(UUID id, String phoneNumber) implements Serializable {
    public Contact toEntity() {
        Contact contact = new Contact();
        contact.setId(this.id);
        contact.setPhoneNumber(this.phoneNumber);
        return contact;
    }
}