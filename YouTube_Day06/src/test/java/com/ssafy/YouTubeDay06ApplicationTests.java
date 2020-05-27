package com.ssafy;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dto.EmployeeDto;
import com.ssafy.model.repo.EmployeeRepo;
import com.ssafy.model.service.EmployeeService;

@SpringBootTest
class YouTubeDay06ApplicationTests {

	@Autowired
	EmployeeService service;
	
	@Autowired
	EmployeeRepo repo;
	
	@Test
	void contextLoads() {
		System.out.println(repo.findEmployee(3));
	}
	
	@Test
	@Transactional
	void Test() {
		List<EmployeeDto> list = new ArrayList<>();
		list = repo.joinEmployees();
		for (EmployeeDto employeeDto : list) {
			System.out.println(employeeDto);
		}
	}

}
