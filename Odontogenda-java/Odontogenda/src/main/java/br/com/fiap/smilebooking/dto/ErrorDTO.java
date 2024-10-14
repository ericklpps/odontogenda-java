package br.com.fiap.smilebooking.dto;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

public record ErrorDTO(String message, LocalDateTime timestamp) {
    public ErrorDTO(String message) {
        this(message, LocalDateTime.now().atOffset(ZoneOffset.UTC).toLocalDateTime());
    }
}
