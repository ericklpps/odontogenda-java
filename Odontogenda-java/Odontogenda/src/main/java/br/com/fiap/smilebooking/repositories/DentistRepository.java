package br.com.fiap.smilebooking.repositories;

import br.com.fiap.smilebooking.models.Dentist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DentistRepository extends JpaRepository<Dentist, UUID> {
}