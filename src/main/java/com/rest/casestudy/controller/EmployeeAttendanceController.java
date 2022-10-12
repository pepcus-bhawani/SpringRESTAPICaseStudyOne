package com.rest.casestudy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rest.casestudy.entity.Attendance;
import com.rest.casestudy.entity.EmployeeEntity;
import com.rest.casestudy.model.EmployeeRespose;
import com.rest.casestudy.services.IAttendanceService;

@RestController
public class EmployeeAttendanceController {
	@Autowired
	IAttendanceService attendance;

	@PostMapping("/attendance")
	public ResponseEntity<EmployeeRespose> getAttendace(@RequestBody String str)
	{

		return attendance.addEmployeeAttendance(str);
				
		
	}
	
	@GetMapping("/emp_attendance")
	public List<Attendance> getEmployeeAttendance()
	{
		
		return attendance.getAllEmployeeWithAttendance();
		
	}
	
	
	
	
}
