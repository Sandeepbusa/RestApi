package com.flm.util;

import org.springframework.stereotype.Component;

import com.flm.dto.EmployeeForm;
import com.flm.entity.Employee;

@Component
public class Converter {

	public Employee getEmployee(EmployeeForm employeeForm) {
		return Employee.builder()
				.id(employeeForm.getId())
				.name(employeeForm.getName())
				.address(employeeForm.getAddress())
				.salary(employeeForm.getSalary())
				.dept_id(employeeForm.getDept_id())
				.build();
	}
	
	public EmployeeForm getEmployeeForm(Employee emp) {
		return EmployeeForm.builder()
				.id(emp.getId())
				.name(emp.getName())
				.address(emp.getAddress())
				.salary(emp.getSalary())
				.dept_id(emp.getDept_id())	
				.build();	
	}
}
