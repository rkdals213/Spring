package com.ssafy.model.repo;

import java.util.List;

import com.ssafy.model.dto.EmployeeDto;

public interface EmployeeRepo {
	List<EmployeeDto> findAllEmployees();

	int addEmployee(EmployeeDto dto);

	EmployeeDto findEmployee(int id);
	
	int updateEmployee(EmployeeDto dto);
	
	int deleteEmployee(int id);
	
	List<EmployeeDto> joinEmployees();
}
