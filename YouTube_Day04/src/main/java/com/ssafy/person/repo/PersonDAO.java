package com.ssafy.person.repo;

import java.util.List;

import com.ssafy.person.dto.Person;

public interface PersonDAO {
    public int insert(Person vo);
    public List<Person> selectAll();
    public Person select(int no);
	public int update(Person vo);
	public int delete(int no);
}



