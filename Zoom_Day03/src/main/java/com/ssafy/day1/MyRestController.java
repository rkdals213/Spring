package com.ssafy.day1;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.zoom3.model.dto.UserInfo;
import com.ssafy.zoom3.model.service.UserService;

@RestController // rest 전용
public class MyRestController {

	static Logger logger = LoggerFactory.getLogger(MyRestController.class);

	@Autowired
	UserService uService;

	// 모든 사용자 정보를 반환해라. --> 데이터 only, --> 누구나 알아먹을 수 있는 문자열
	@GetMapping("/user")
	public ResponseEntity<Map<String, Object>> selectAll() {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			List<UserInfo> users = uService.selectAll();// -- RuntimeException
			entity = handleSuccess(users);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@GetMapping("/user/{userid}")
	public ResponseEntity<Map<String, Object>> select(@PathVariable String userid) {
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			UserInfo info = uService.login(userid);// -- RuntimeException
			entity = handleSuccess(info);
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	
	@PostMapping("/user")
	public ResponseEntity<Map<String, Object>> regist(@RequestBody UserInfo userInfo){
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			int result = uService.regist(userInfo);
			entity = handleSuccess(userInfo.getUserid()+"가 추가되었습니다.");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@PutMapping("/user")
	public ResponseEntity<Map<String, Object>> update(@RequestBody UserInfo userInfo){
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			int result = uService.update(userInfo);
			entity = handleSuccess(userInfo.getUserid()+"가 수정되었습니다.");
		} catch (RuntimeException e) {
			entity = handleException(e);
		}
		return entity;
	}
	
	@DeleteMapping("/user/{userid}")
	public ResponseEntity<Map<String, Object>> delete(@PathVariable String userid){
		ResponseEntity<Map<String, Object>> entity = null;
		try {
			int result = uService.leave(userid);
			entity = handleSuccess(userid+"가 탈퇴되었습니다.");
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
