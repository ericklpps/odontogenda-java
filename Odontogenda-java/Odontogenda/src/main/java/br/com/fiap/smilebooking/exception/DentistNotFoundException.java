package br.com.fiap.smilebooking.exception;

import jakarta.persistence.EntityNotFoundException;

public class DentistNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "Dentist not found";
    public DentistNotFoundException() {
        super(MESSAGE);
    }
}
