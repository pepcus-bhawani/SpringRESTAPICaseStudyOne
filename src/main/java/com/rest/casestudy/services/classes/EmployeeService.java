package com.rest.casestudy.services.classes;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.yaml.snakeyaml.util.EnumUtils;

import com.rest.casestudy.dto.EmployeeDTO;
import com.rest.casestudy.entity.Department;
import com.rest.casestudy.entity.EmployeeEntity;
import com.rest.casestudy.model.CountRespose;
import com.rest.casestudy.model.EmployeeRespose;
import com.rest.casestudy.model.EmployeeWithCountResponse;
import com.rest.casestudy.repo.EmployeeRepo;
import com.rest.casestudy.services.IEmployeeService;

@Component
public class EmployeeService implements IEmployeeService {

	@Autowired
	EmployeeRepo empRepo;


	public ResponseEntity<EmployeeRespose> addEmployee(EmployeeDTO empDto) {
 
		   System.out.println(empDto);
		   
		   if(Department.isInEnum(empDto.getDepartment().toString(), Department.class)==false)
		   {
			  System.out.println("not Belong");  
		   }
		   
		   EmployeeEntity employee= new EmployeeEntity();
		   BeanUtils.copyProperties(empDto, employee); 
		   System.out.println(employee);
			empRepo.save(employee);

			return ResponseEntity.status(HttpStatus.OK).body(new EmployeeRespose(" Employee Saved"));
	
	}

	@Override
	public List<EmployeeEntity> getAllEmployee() {

		return empRepo.findAll();
	}

	public List<EmployeeEntity> getAttendanceByCity_day_isPresent(String city, Integer day, Boolean isPresent) {
		System.out.println("inside service");
		return empRepo.getAttendanceByCity_Day_IsPresent(isPresent, day, city);

	}

	@Override
	public List<EmployeeEntity> getAttendanceByDepartment_day_isParesent(Integer department, Integer day,
			Boolean isPresent) {

		return empRepo.getAttendanceByDepartmentDayIspresent(department, day, isPresent);
	}

	@Override
	public List<EmployeeEntity> getAttendaceByCityDepartmentDayIsPresent(String city, Integer department, Integer day,
			Boolean isPresent) {
		
		if(day>31 || day<0)
		{
			System.out.println("day grether");
			throw new DataIntegrityViolationException("Day Must Be 1-31");
		}

		return empRepo.getAttendanceByCityDepartmentDayIsPresent(city, department, day, isPresent);
	}

	
	public EmployeeWithCountResponse getCountRecord() {
        List l=new ArrayList<>();
	    l =empRepo.findAll();
	    int count=l.size();
	    EmployeeWithCountResponse ecount=new EmployeeWithCountResponse();
	    ecount.setCoutn(count);
	    ecount.setL( l);
	    
	    return ecount;
	}

}
