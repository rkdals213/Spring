package com.ssafy.model.repo;

import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.model.dto.UserInfo;

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

	@Override
	public List<UserInfo> selectIf(String userid) {
		return template.selectList(ns + "selectIf", userid);
	}

	@Override
	public List<UserInfo> selectSome(Map<String, Object> param) {
		return template.selectList(ns + "selectSome", param);
	}
}
