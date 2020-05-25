package com.ssafy.zoom3.model.repo;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.zoom3.model.dto.UserInfo;

@Repository
public class UserRepoImpl implements UserRepo {
	private static String ns = "com.ssafy.mapper.UserInfo.";

	@Autowired
	SqlSessionTemplate template;

	@Override
	public UserInfo select(String userid) {
		return template.selectOne(ns + "select", userid);
	}

	@Override
	public List<UserInfo> selectAll() {
		return template.selectList(ns + "selectAll");
	}

	@Override
	public UserInfo selectDetail(String userId) {
		return template.selectOne(ns + "selectDetail", userId);
	}

	@Override
	public int insert(UserInfo info) {
		return template.insert(ns + "insert", info);
	}

	@Override
	public int update(UserInfo info) {
		return template.update(ns+"update", info);
	}

	@Override
	public int delete(String userId) {
		return template.delete(ns+"delete", userId);
	}
}
