package com.rest.casestudy.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rest.casestudy.dto.EmployeeDTO;
import com.rest.casestudy.entity.Department;
import com.rest.casestudy.entity.EmployeeEntity;
import com.rest.casestudy.model.CountRespose;
import com.rest.casestudy.model.EmployeeRespose;
import com.rest.casestudy.model.EmployeeWithCountResponse;
import com.rest.casestudy.services.IEmployeeService;

@RestController
public class EmployeeController {
	@Autowired
	IEmployeeService empService;
	
	@GetMapping("/employee")
	public List<EmployeeEntity> getAllEmpoyee()
	{
	
		return empService.getAllEmployee();
	}
	
	
	
	@GetMapping("/totalemployee")
	public EmployeeWithCountResponse getAllEmp()
	{
		return empService.getCountRecord();
	}
	
	@PostMapping("/employee")
	public ResponseEntity<EmployeeRespose> addEmployee( @RequestBody EmployeeDTO empDto) 
	{
		System.out.println("Controller");
		return empService.addEmployee(empDto);
		
	}
	
	
	@GetMapping("/attendancebycityday")
	public List<EmployeeEntity> getEmployeeAttendaceReport(@RequestParam(value = "city") String city,@RequestParam(value="day") Integer day, @RequestParam(value="present") Boolean present)
	{
		
		return empService.getAttendanceByCity_day_isPresent(city, day, present);
		
	}
	
	@GetMapping("/attendancebydepartmentandday")
	public List<EmployeeEntity> getAttendanceByDepartmentDay(@RequestParam(value="department") Department department,@RequestParam(value="day") Integer day,@RequestParam(value="present") Boolean isPresent)
	{
		
		return empService.getAttendanceByDepartment_day_isParesent(department.ordinal(), day, isPresent);
		
	}
	
	@GetMapping("/attendancebycitydepartmentday")
	public List<EmployeeEntity> getAttendaceByCityDepartmentDayIsPresent(@Valid @RequestParam(value="city") String city,  @RequestParam(value="department") Department department ,@RequestParam(value="day") Integer day, @RequestParam(value="present") Boolean isPresent)
	{
		return empService.getAttendaceByCityDepartmentDayIsPresent(city, department.ordinal(), day, isPresent);
	}
	

}
