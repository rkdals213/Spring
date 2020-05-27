package com.ssafy.model.repo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.EmployeeDto;

@Repository
public class EmployeeRepoImpl implements EmployeeRepo{

	private static String ns = "com.ssafy.mapper.Employee.";

	@Autowired
	SqlSessionTemplate template;
	
	@Override
	public List<EmployeeDto> findAllEmployees() {
		return template.selectList(ns+"selectAll");
	}

	@Override
	public int addEmployee(EmployeeDto dto) {
		return template.insert(ns+"insert", dto);
	}

	@Override
	public EmployeeDto findEmployee(int id) {
		return template.selectOne(ns+"select", id);
	}

	@Override
	public int updateEmployee(EmployeeDto dto) {
		return template.update(ns+"update", dto);
	}

	@Override
	public int deleteEmployee(int id) {
		return template.delete(ns+"delete", id);
	}

	@Override
	public List<EmployeeDto> joinEmployees() {
		return template.selectList(ns+"selectjoin");
	}

}
