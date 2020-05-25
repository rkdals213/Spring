package com.ssafy.zoom3.model.repo;

import java.util.List;

import com.ssafy.zoom3.model.dto.UserInfo;

public interface UserRepo {

	UserInfo select(String userid);
	
	List<UserInfo> selectAll();
	
	UserInfo selectDetail(String userId);
	
	int insert(UserInfo info);
	
	int update(UserInfo info);
	
	int delete(String userId);
}
