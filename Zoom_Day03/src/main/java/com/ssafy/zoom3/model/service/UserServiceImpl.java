package com.ssafy.zoom3.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.zoom3.model.dto.UserInfo;
import com.ssafy.zoom3.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo uRepo;

	@Override
	public UserInfo login(String userid) {
		return uRepo.select(userid);
	}

	@Override
	public List<UserInfo> selectAll() {
		return uRepo.selectAll();
	}

	@Override
	public int regist(UserInfo info) {
		return uRepo.insert(info);
	}

	@Override
	public int update(UserInfo info) {
		return uRepo.update(info);
	}

	@Override
	public int leave(String userId) {
		return uRepo.delete(userId);
	}

}
