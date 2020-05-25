package com.ssafy.zoom3.model.repo;

import java.util.List;

import com.ssafy.zoom3.model.dto.UserInfo;

public interface UserRepo {
	UserInfo select(UserInfo info);
	List<UserInfo> selectAll();
	UserInfo selectDetail(String userId);
}
