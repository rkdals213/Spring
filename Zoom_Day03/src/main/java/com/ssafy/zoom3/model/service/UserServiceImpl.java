package com.ssafy.zoom3.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.zoom3.model.dto.UserInfo;
import com.ssafy.zoom3.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepo uRepo;
	
	@Override
	public UserInfo login(UserInfo info) {
		return uRepo.select(info);
	}

	@Override
	public List<UserInfo> selectAll() {
		return uRepo.selectAll();
	}
	
	
	
}
