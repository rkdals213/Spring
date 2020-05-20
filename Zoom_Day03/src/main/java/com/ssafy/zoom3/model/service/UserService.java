package com.ssafy.zoom3.model.service;

import java.util.List;

import com.ssafy.zoom3.model.dto.UserInfo;

public interface UserService {
	UserInfo login(UserInfo info);
	List<UserInfo> selectAll();
}
