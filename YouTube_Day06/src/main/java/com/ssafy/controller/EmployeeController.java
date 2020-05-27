package com.ssafy.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.model.dto.EmployeeDto;
import com.ssafy.model.service.EmployeeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

//http://localhost:8080/ssafy/swagger-ui.html
@CrossOrigin(origins = {"*"}, maxAge = 6000)
@RestController
@RequestMapping("/api")
@Api(value="SSAFY")
public class EmployeeController {
	
	public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService  employeeService; 


	@ApiOperation(value = "모든 사원의 정보를 반환한다", response = Map.class)
    @GetMapping("/employee/all")
	public ResponseEntity<Map<String, Object>> findAllEmployees() throws Exception {
		logger.info("1-------------findAllEmployees-----------------------------"+new Date());
		ResponseEntity<Map<String, Object>> entity = null;
		logger.debug("selectAll");
		try {
			List<EmployeeDto> employees = employeeService.findAllEmployees();
			entity = handleSuccess(employees);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		System.out.println(entity);
		return entity;
	}
    
	@ApiOperation(value = "한 사원의 정보를 반환한다", response = Map.class)
    @GetMapping("/employee/{id}")
	public ResponseEntity<Map<String, Object>> findEmployee(@PathVariable int id) throws Exception {
		logger.info("2-------------findEmployee-----------------------------"+new Date());
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			EmployeeDto employee =employeeService.findEmployee(id);
			entity = handleSuccess(employee);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}    
    
	@ApiOperation(value = "사원의 정보를 업데이트한다", response = Map.class)
    @PutMapping("/employee")
	public ResponseEntity<Map<String, Object>> updateEmployee(@RequestBody EmployeeDto dto) throws Exception {
		logger.info("3-------------updateEmployee-----------------------------"+new Date());
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			int result = employeeService.updateEmployee(dto);
			entity = handleSuccess(dto.getId()+"가 수정되었습니다.");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
    
	@ApiOperation(value = "사원의 정보를 삭제한다", response = Map.class)
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Map<String, Object>> deleteEmployee(@PathVariable int id) throws Exception {
		logger.info("4-------------updateEmployee-----------------------------"+new Date());
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			int result = employeeService.deleteEmployee(id);
			entity = handleSuccess(id+"가 삭제되었습니다.");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
    
	@ApiOperation(value = "사원의 정보를 추가한다", response = Map.class)
    @PostMapping("/employee/form")
    public ResponseEntity<Map<String, Object>> insertEmployee(@RequestBody EmployeeDto dto) throws Exception {
    	logger.info("5-------------insertEmployee-----------------------------"+new Date());
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			System.out.println(dto);
			int result = employeeService.addEmployee(dto);
			entity = handleSuccess(dto.getId()+"가 추가되었습니다.");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
    }
    
	private ResponseEntity<Map<String, Object>> handleSuccess(Object data) {
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", true);
		resultMap.put("data", data);
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.OK);
	}

	private ResponseEntity<Map<String, Object>> handleException(Exception e) {
		logger.error("예외 발생", e);
		Map<String, Object> resultMap = new HashMap<>();
		resultMap.put("status", false);
		resultMap.put("data", e.getMessage());
		return new ResponseEntity<Map<String, Object>>(resultMap, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
