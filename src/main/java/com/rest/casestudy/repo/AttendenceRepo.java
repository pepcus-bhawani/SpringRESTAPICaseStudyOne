package com.rest.casestudy.repo;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.rest.casestudy.entity.Attendance;
import com.rest.casestudy.entity.EmployeeEntity;

public interface AttendenceRepo extends JpaRepository<Attendance, Long> {
    @Modifying
    @Transactional
	@Query(value = "insert into attendance(employee_id,day,is_present) values(?,?,?);", nativeQuery = true)
	void saveAttendance(Long id,Integer day, Boolean isPresent);
    
    @Modifying
    @Transactional
	@Query(value = "insert into attendance(employee_id,day,is_present) values(?,?,?);", nativeQuery = true)
	Boolean saveAttendance1(Long id,Integer day, Boolean isPresent);
    
    
   
    
  
	
}
