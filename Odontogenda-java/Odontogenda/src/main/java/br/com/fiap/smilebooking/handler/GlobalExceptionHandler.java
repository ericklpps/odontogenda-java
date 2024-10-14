package br.com.fiap.smilebooking.handler;

import br.com.fiap.smilebooking.dto.ErrorDTO;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static ResponseEntity<ErrorDTO> createErrorResponse(Exception e, Integer statusCode) {
        return ResponseEntity.status(HttpStatusCode.valueOf(statusCode)).body(new ErrorDTO(e.getMessage()));
    }

    private static ResponseEntity<ErrorDTO> createErrorResponse(Exception e) {
        return ResponseEntity.status(HttpStatusCode.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value())).body(new ErrorDTO(e.getMessage()));
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ErrorDTO> response(EntityNotFoundException e) {
        return createErrorResponse(e, HttpStatus.NOT_FOUND.value());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDTO> response(Exception e) {
        return createErrorResponse(e);
    }
}
