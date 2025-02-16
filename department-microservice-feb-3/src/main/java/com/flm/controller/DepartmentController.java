package com.flm.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.flm.dto.DepartmentForm;
import com.flm.entity.Department;
import com.flm.exception.DepartmentNotFoundException;
import com.flm.service.DepartmentService;
import com.flm.util.Converter;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

	private final DepartmentService departmentService;
	private final Converter converter;

	@PostMapping("/saveDepartment")
	public DepartmentForm saveDepartment(@RequestBody DepartmentForm departmentForm) {
		Department dept = converter.getDepartment(departmentForm);
		dept = departmentService.saveDepartment(dept);
		return converter.getDepartmentForm(dept);

	}

	@GetMapping("/getDepartment/{id}")
	public DepartmentForm getDepartment(@PathVariable Long id) throws DepartmentNotFoundException {
		return getDepartmentForm(id);

	}

	@GetMapping("/getDepartment")
	public DepartmentForm getDeprtmentParam(@RequestParam("dept_id") Long id) throws DepartmentNotFoundException {
		return getDepartmentForm(id);
	}

	private DepartmentForm getDepartmentForm(Long id) throws DepartmentNotFoundException {
		Department dept = departmentService.getDepartment(id);
		return converter.getDepartmentForm(dept);

	}

}
