package com.flm.util;

import org.springframework.stereotype.Component;

import com.flm.dto.DepartmentForm;
import com.flm.entity.Department;

@Component
public class Converter {

	public Department getDepartment(DepartmentForm departmentForm) {
		return Department.builder()
				.id(departmentForm.getId())
				.name(departmentForm.getName())
				.location(departmentForm.getLocation())
				.build();
	}
	
	public DepartmentForm getDepartmentForm(Department dept) {
		return DepartmentForm.builder()
				.id(dept.getId())
				.name(dept.getName())
				.location(dept.getLocation())
				.build();
	}
}
