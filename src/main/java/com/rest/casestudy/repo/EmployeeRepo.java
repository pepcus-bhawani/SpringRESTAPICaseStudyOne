package com.rest.casestudy.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.rest.casestudy.entity.Department;
import com.rest.casestudy.entity.EmployeeEntity;
@Component
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {
	
	@Modifying
    @Transactional
    @Query(value="select employee.name,employee.city,employee.email,employee.emp_id,employee.department from employee inner join attendance on emp_id= employee_id where is_present = ? and day = ? and city=? ;", nativeQuery = true)
    List<EmployeeEntity> getAttendanceByCity_Day_IsPresent(Boolean isPresent,Integer day, String city);
	
	@Modifying
    @Transactional
    @Query(value="select employee.name,employee.city,employee.email,employee.emp_id,employee.department from employee inner join attendance on emp_id= employee_id where department = ? and day = ? and is_present=? ;", nativeQuery = true)
    List<EmployeeEntity> getAttendanceByDepartmentDayIspresent(Integer department,Integer day,Boolean isPresent);
	@Modifying
    @Transactional
    @Query(value="select employee.name,employee.city,employee.email,employee.emp_id,employee.department from employee inner join attendance on emp_id= employee_id where city=? and  department = ? and day = ? and is_present=? ;", nativeQuery = true)
    List<EmployeeEntity> getAttendanceByCityDepartmentDayIsPresent(String city, Integer department, Integer day, Boolean isPresent);
}
