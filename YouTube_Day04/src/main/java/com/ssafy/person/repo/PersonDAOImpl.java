package com.ssafy.person.repo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ssafy.person.dto.Person;

@Repository
public class PersonDAOImpl implements PersonDAO{

	@Autowired
	SqlSession sqlSession;
	
	
	@Override
	public int insert(Person vo) {		
		return sqlSession.insert("person.insert",vo);
	}

	@Override
	public List<Person> selectAll() {
		return sqlSession.selectList("person.selectAll");
	}

	@Override
	public Person select(int no) {
		return sqlSession.selectOne("person.select",no);
	}

	@Override
	public int update(Person vo) {
		return sqlSession.update("person.update",vo);
	}

	@Override
	public int delete(int no) {
		return sqlSession.delete("person.delete",no);
	}

}
