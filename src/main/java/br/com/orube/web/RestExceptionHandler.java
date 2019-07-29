package br.com.orube.web;

import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.ResponseEntity.notFound;
import static org.springframework.http.ResponseEntity.status;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import br.com.orube.security.jwt.InvalidJwtAuthenticationException;
import lombok.extern.slf4j.Slf4j;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {

    @ExceptionHandler(value = { ClienteNotFoundException.class })
    public ResponseEntity vehicleNotFound(ClienteNotFoundException ex, WebRequest request) {

	log.debug("handling ClienteNotFoundException...");
	return notFound().build();
    }

    @ExceptionHandler(value = { InvalidJwtAuthenticationException.class })
    public ResponseEntity invalidJwtAuthentication(InvalidJwtAuthenticationException ex, WebRequest request) {

	log.debug("handling InvalidJwtAuthenticationException...");
	return status(UNAUTHORIZED).build();
    }
}
