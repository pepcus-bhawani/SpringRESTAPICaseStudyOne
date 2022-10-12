package com.rest.casestudy.services;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.rest.casestudy.entity.Attendance;
import com.rest.casestudy.entity.EmployeeEntity;
import com.rest.casestudy.model.EmployeeRespose;

@Component
public interface IAttendanceService {
	
	public ResponseEntity<EmployeeRespose> addEmployeeAttendance(String str);
	
	public List<Attendance> getAllEmployeeWithAttendance();
	
	//public List<EmployeeEntity> getEmployeeAttendanceReport(Integer id,String department,Boolean isPresent);

	
}
