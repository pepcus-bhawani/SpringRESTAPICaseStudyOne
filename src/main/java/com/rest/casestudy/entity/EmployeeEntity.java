package com.rest.casestudy.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.rest.casestudy.dto.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employee")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	@NotBlank(message = "Please Provide Value For Name")
	@NotNull(message = "Please Provide Value For Name")
	private String name;
	
	@NotBlank(message = "Please Provide Value For City")
	@NotNull(message = "Please Provide Value For City")
	private String city;
	@NotNull(message = "Please Provide Value For Email")
	@Email(message = "Email Not Vailid")
	@Column(nullable = false,unique = true)
	private String email;
	
	@NotNull(message = "Please Provide Value For Department")
	Department department;
   
}
