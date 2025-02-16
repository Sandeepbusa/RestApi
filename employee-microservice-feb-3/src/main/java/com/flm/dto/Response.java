package com.flm.dto;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class Response {
	
	private EmployeeForm employeeForm;
	private DepartmentForm departmentForm;

}
