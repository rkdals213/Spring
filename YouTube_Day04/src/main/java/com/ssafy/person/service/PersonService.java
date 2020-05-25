package com.ssafy.person.service;

import java.util.List;

import com.ssafy.person.dto.Person;

public interface PersonService {
    public int registry(Person person);
    public int modify(Person person);
    public int remove(int no);
    public Person find(int no);
    public List<Person> findAll();
}


