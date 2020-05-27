package com.ssafy.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.model.dto.Board;
import com.ssafy.model.dto.UserInfo;
import com.ssafy.model.repo.BoardRepo;
import com.ssafy.model.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo uRepo;
	
	@Autowired
	BoardRepo bRepo;

	@Override
	public UserInfo login(String userid) {
		return uRepo.select(userid);
	}

	@Override
	public List<UserInfo> selectAll() {
		return uRepo.selectAll();
	}

	@Override
	@Transactional
	public int regist(UserInfo info) {		
		// 회원가입에 성공하면 board에 글 추가
		uRepo.insert(info);
		return bRepo.insert(new Board(0,"hong", info.getUserid()+"님이 가입하였습니다"));
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
