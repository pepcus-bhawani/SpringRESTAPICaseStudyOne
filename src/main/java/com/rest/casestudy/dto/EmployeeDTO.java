package com.rest.casestudy.dto;
import com.rest.casestudy.entity.Department;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
	
	private String name;
	private String city;
	private String email;
	//private DepartmentDto department;
	private Department department;
	

}
