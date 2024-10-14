package br.com.fiap.smilebooking.services.impl;

import br.com.fiap.smilebooking.dto.CustomerDTO;
import br.com.fiap.smilebooking.exception.CustomerNotFoundException;
import br.com.fiap.smilebooking.models.Customer;
import br.com.fiap.smilebooking.repositories.CustomerRepository;
import br.com.fiap.smilebooking.services.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository repository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.repository = customerRepository;
    }

    @Override
    public CustomerDTO add(CustomerDTO customerDto) {
        Customer customer = customerDto.toEntity();
        return repository.save(customer).toDTO();
    }

    @Override
    public CustomerDTO get(String id) {
        Customer customer = repository.findById(UUID.fromString(id)).orElseThrow(CustomerNotFoundException::new);
        return customer.toDTO();
    }

    @Override
    public List<CustomerDTO> getAll() {
        return repository.findAll().stream().map(Customer::toDTO).toList();
    }

    @Override
    public void delete(String id) {
        repository.deleteById(UUID.fromString(id));
    }

    @Override
    public void update(String id, CustomerDTO dto) {
        UUID uuid = UUID.fromString(id);
        if (!repository.existsById(uuid)) {
            throw new CustomerNotFoundException();
        }
        repository.save(dto.toEntity());
    }
}
