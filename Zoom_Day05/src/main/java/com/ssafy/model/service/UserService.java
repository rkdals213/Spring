package com.ssafy.model.service;

import java.util.List;

import com.ssafy.model.dto.UserInfo;

public interface UserService {
	
	UserInfo login(String userid);
	
	List<UserInfo> selectAll();
	
	int regist(UserInfo info);
	
	int update(UserInfo info);
	
	int leave(String userId);
}
