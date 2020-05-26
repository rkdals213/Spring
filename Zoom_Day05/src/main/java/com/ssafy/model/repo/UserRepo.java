package com.ssafy.model.repo;

import java.util.List;
import java.util.Map;

import com.ssafy.model.dto.UserInfo;

public interface UserRepo {

	UserInfo select(String userid);
	
	List<UserInfo> selectAll();
	
	UserInfo selectDetail(String userId);
	
	int insert(UserInfo info);
	
	int update(UserInfo info);
	
	int delete(String userId);
	
	List<UserInfo> selectIf(String userid);
	
	List<UserInfo> selectSome(Map<String, Object> param);
}
