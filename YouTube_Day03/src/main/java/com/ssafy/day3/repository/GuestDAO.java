package com.ssafy.day3.repository;

import java.util.List;

import com.ssafy.day3.dto.Guest;

public interface GuestDAO {
    public void insert(Guest vo);
    public List<Guest> selectAll();
    public List<Guest> selectPage(int page, int limit);
    public Guest select(int no);
	public void update(Guest vo);
	public void delete(int no);
    
}