package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.EmployeeDto;

public interface EmployeeService {

	List<EmployeeDto> findAllEmployees();
	
	EmployeeDto findEmployee(int id);

	int addEmployee(EmployeeDto dto);

	int updateEmployee(EmployeeDto dto);

	int deleteEmployee(int id);
}
