package com.abc.driverservice.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(NotValidId.class)
	public ResponseEntity<ErrorDetails> handleInvalidIdException(NotValidId ie, WebRequest wr) {
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), ie.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleDriverNotFoundException(ResourceNotFoundException e, WebRequest wr) {
		ErrorDetails err = new ErrorDetails(LocalDateTime.now(), e.getMessage(), wr.getDescription(false));
		return new ResponseEntity<ErrorDetails>(err, HttpStatus.BAD_REQUEST);
	}


}