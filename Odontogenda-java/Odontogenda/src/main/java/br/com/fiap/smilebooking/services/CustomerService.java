package br.com.fiap.smilebooking.services;

import br.com.fiap.smilebooking.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    CustomerDTO add(CustomerDTO customerDto);
    CustomerDTO get(String id);
    List<CustomerDTO> getAll();
    void delete(String id);
    void update(String id, CustomerDTO customerDto);
}
