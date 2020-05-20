package com.ssafy.day1.model.dto;

import java.util.Date;
// DTO --> java beans, toString, 파라미터 생성자

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int boardNo;
	private String buddyId;
	private Date regDate;
	private String boardContent;
	public int add(String a, String b) {
		System.out.println("파라미터 잘 들어오나? ㅜㅜ: "+a+", "+b);
		int result = 0;
		try {
			result = Integer.parseInt(a) + Integer.parseInt(b);
		}catch(NumberFormatException e) {
			System.out.println("오류 발생: "+e.getMessage());
		}
		System.out.println("여기까지 오면 결과 생성됨: "+result);
		return result;
	}
}
