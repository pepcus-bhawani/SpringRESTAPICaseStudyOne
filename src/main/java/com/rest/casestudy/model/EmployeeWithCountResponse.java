package com.rest.casestudy.model;

import com.rest.casestudy.entity.EmployeeEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
public class EmployeeWithCountResponse {

	private Integer coutn;
	private java.util.List<EmployeeEntity> l;

}
