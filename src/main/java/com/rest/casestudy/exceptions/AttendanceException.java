package com.rest.casestudy.exceptions;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AttendanceException extends RuntimeException {

	String message;
	
}
