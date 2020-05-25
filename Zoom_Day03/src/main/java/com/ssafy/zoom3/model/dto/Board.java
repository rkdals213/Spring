package com.ssafy.zoom3.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private Integer no;
	private String userid;
	private String content;
		
	public Board(Integer no, String userid, String content) {
		super();
		this.no = no;
		this.userid = userid;
		this.content = content;
	}
	
	// 작성자 이름도 알고싶고.. --> 
	private UserInfo user;
}
