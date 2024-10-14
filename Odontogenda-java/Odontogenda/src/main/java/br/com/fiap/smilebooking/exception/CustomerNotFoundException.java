package br.com.fiap.smilebooking.exception;

import jakarta.persistence.EntityNotFoundException;

public class CustomerNotFoundException extends EntityNotFoundException {
    public static final String MESSAGE = "Customer not found";
    public CustomerNotFoundException() {
        super(MESSAGE);
    }
}
