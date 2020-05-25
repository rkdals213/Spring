package com.ssafy.zoom3.model.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserInfo {
	private String userid;
	private String pass;	
	
	public UserInfo(String userid, String pass) {
		super();
		this.userid = userid;
		this.pass = pass;
	}

	private List<Board> boards;
}
