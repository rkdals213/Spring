package com.ssafy.person.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.person.dto.Person;
import com.ssafy.person.repo.PersonDAO;

@Service
public class PersonServiceImpl implements PersonService{

	@Autowired
	PersonDAO dao;

	@Override
	public int registry(Person person) {
		return dao.insert(person);
	}

	@Override
	public int modify(Person person) {
		return dao.update(person);
	}

	@Override
	public int remove(int no) {
		return dao.delete(no);
	}

	@Override
	public Person find(int no) {
		return dao.select(no);
	}

	@Override
	public List<Person> findAll() {		
		return dao.selectAll();
	}
}
