package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.ssafy.model.dto.EmployeeDto;
import com.ssafy.model.repo.EmployeeRepo;

@Controller
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeRepo eRepo;
	
	@Override
	public List<EmployeeDto> findAllEmployees() {
		return eRepo.findAllEmployees();
	}

	@Override
	public int addEmployee(EmployeeDto dto) {
		return eRepo.addEmployee(dto);
	}

	@Override
	public EmployeeDto findEmployee(int id) {
		return eRepo.findEmployee(id);
	}

	@Override
	public int updateEmployee(EmployeeDto dto) {
		return eRepo.updateEmployee(dto);
	}

	@Override
	public int deleteEmployee(int id) {
		return eRepo.deleteEmployee(id);
	}

}
