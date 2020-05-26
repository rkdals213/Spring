package com.ssafy.model.dto;

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

	private List<Board> boards;

	public UserInfo(String userid, String pass) {
		super();
		this.userid = userid;
		this.pass = pass;
	}
}
