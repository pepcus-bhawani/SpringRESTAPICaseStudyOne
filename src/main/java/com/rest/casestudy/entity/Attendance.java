package com.rest.casestudy.entity;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import lombok.Data;

@Entity
@Data
@Component
public class Attendance {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Max(31)
	@NotNull(message = "Please Provide Value For Day")
	private Integer day;
	
	@NotNull(message = "Please Provide Value For Day")
	Boolean isPresent;
	
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "employee_Id", referencedColumnName = "empId")
	private EmployeeEntity employee;
	
	
	
}
