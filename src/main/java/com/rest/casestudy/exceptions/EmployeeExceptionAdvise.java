package com.rest.casestudy.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


import com.rest.casestudy.model.EmployeeRespose;

@RestControllerAdvice
public class EmployeeExceptionAdvise extends ResponseEntityExceptionHandler {
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmployeeException.class)
	public Map<String, String> wrongDataFormate(EmployeeException ex) {
		Map<String, String> map = new HashMap<>();
		map.put("Error ", ex.getMessage());
		return map;
	}
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(DataIntegrityViolationException.class)
	public Map<String, String> userNotFountException(DataIntegrityViolationException ex) {

		Map<String, String> map = new HashMap<>();

		map.put("Error ", ex.getMessage());

		return map;

	}
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = ConstraintViolationException.class)
	public List handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {

		List l = new ArrayList<>();

		for (ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			Map<String, String> errors = new HashMap<>();
			errors.put("Error", violation.getMessage());
			System.out.println(errors);
			l.add(errors);
		}

		return l;
	}
	
	
}
