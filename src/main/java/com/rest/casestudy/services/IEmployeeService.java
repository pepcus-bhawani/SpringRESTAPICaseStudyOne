package com.rest.casestudy.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.rest.casestudy.dto.EmployeeDTO;
import com.rest.casestudy.entity.Department;
import com.rest.casestudy.entity.EmployeeEntity;
import com.rest.casestudy.model.CountRespose;
import com.rest.casestudy.model.EmployeeRespose;
import com.rest.casestudy.model.EmployeeWithCountResponse;
@Component
public interface IEmployeeService {
	
	public ResponseEntity<EmployeeRespose> addEmployee(EmployeeDTO emp);
	
	public List<EmployeeEntity> getAllEmployee();
	
	public List<EmployeeEntity> getAttendanceByCity_day_isPresent(String city,Integer day, Boolean isPresent);
	
	public List<EmployeeEntity> getAttendanceByDepartment_day_isParesent(Integer department,Integer day,Boolean isPresent);
	
	public List<EmployeeEntity> getAttendaceByCityDepartmentDayIsPresent(String city,Integer department,Integer day, Boolean isPresent);

	public EmployeeWithCountResponse getCountRecord();
}
