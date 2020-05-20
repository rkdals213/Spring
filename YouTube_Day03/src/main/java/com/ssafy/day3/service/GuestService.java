package com.ssafy.day3.service;

import com.ssafy.day3.dto.Guest;

public interface GuestService {
    public void registry(Guest guest);
    public void modify(Guest guest);
    public void remove(int no);
    public void find(int no);
    public void findAll();
}


