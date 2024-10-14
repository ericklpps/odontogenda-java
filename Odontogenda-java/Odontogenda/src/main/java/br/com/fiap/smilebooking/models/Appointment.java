package br.com.fiap.smilebooking.models;

import br.com.fiap.smilebooking.dto.AppointmentDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Builder
@Table(name = "appointments")
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private LocalDate date;

    @Column(nullable = false)
    private LocalDateTime entryTime;

    @Column(nullable = false)
    private LocalDateTime estimatedExitTime;

    @ManyToOne
    @JoinColumn(name = "dentist_id")
    private Dentist dentist;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    public AppointmentDTO toDto() {
        return new AppointmentDTO(this.getId(), this.getDate(), this.getEntryTime(), this.getEstimatedExitTime());
    }
}