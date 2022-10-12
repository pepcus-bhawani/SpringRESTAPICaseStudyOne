package com.rest.casestudy.services.classes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.rest.casestudy.entity.Attendance;
import com.rest.casestudy.entity.EmployeeEntity;
import com.rest.casestudy.exceptions.EmployeeException;
import com.rest.casestudy.model.EmployeeRespose;
import com.rest.casestudy.repo.AttendenceRepo;
import com.rest.casestudy.services.IAttendanceService;

@Component
public class AttendanceService implements IAttendanceService {

	@Autowired
	Attendance attendance;

	@Autowired
	AttendenceRepo attendanceRepo;

	@Override
	public ResponseEntity<EmployeeRespose> addEmployeeAttendance(String str) {
		Boolean isPresent = null;

		try {

			String arr[] = str.split(",");
			Long id = Long.parseLong(arr[0]);
			Integer day = Integer.parseInt(arr[1]);
			
			if(day>31 || day<0)
			{
				return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new EmployeeRespose("Day Value Invailid"));
			}
			
			if (arr[2].equals("true") || arr[2].equals("false")) 
			{
				isPresent = Boolean.parseBoolean(arr[2]);
				
			} else {
				return ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.body(new EmployeeRespose(" Please Provide Correct Boolean Value ie: true or false "));

			}
			attendanceRepo.saveAttendance(id, day, isPresent);

		} catch (Exception e) {
			System.out.println("inside catch");

			System.out.println(e.getClass().toString());

			if (e.getClass().toString().equals("class org.springframework.dao.DataIntegrityViolationException")) {
				throw new DataIntegrityViolationException("Employee With Given Id Does not Exist");
				// return ResponseEntity.status(HttpStatus.OK).body(new EmployeeRespose("
				// Employee With Given Id Does not Exist"));
			}

			throw new EmployeeException(
					"Attendance Formate Should Be = EmployeeID,Day,IsPresent(true/flase" + "  Default is: FALSE");
			
		}

		return ResponseEntity.status(HttpStatus.OK).body(new EmployeeRespose(" Employee Attendance Saved"));

	}

	@Override
	public List<Attendance> getAllEmployeeWithAttendance() {

		return attendanceRepo.findAll();
	}

}
