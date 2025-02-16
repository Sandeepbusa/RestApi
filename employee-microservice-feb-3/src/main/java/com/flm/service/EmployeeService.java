package com.flm.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.flm.dto.DepartmentForm;
import com.flm.dto.EmployeeForm;
import com.flm.dto.Response;
import com.flm.entity.Employee;
import com.flm.exception.EmployeeNotFoundException;
import com.flm.repository.EmployeeRepository;
import com.flm.util.Converter;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeService {

	private final EmployeeRepository employeeRepository;
	private final RestTemplate restTemplate;
	private final Converter converter;
	private final Response response;

	@Transactional
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	public Response getEmployee(Long id) throws EmployeeNotFoundException {
		Optional<Employee> opt = employeeRepository.findById(id);
		EmployeeForm eForm = null;
		if (opt.isPresent()) {
			eForm = converter.getEmployeeForm(opt.get());
			response.setEmployeeForm(eForm);
		} else
			throw new EmployeeNotFoundException("Employee not found..!!!");
		DepartmentForm departmentForm = restTemplate
				.getForObject("http://DEPARTMENT-MICROSERVICE/dept/getDepartment/" + eForm.getDept_id(), DepartmentForm.class);
		response.setDepartmentForm(departmentForm);
		return response;
	}
}
