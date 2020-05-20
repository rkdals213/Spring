package com.ssafy.day03.db;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

public class JDBCTest { // DB 첫번쨰 테스트

	@Test
	public void testConnection() throws Exception{
		//1.드라이버 로딩  2.연결객체생성
	   Class.forName("com.mysql.cj.jdbc.Driver");
	   Connection conn=null;
	   
	   try {	
		conn= DriverManager.getConnection
    ("jdbc:mysql://127.0.0.1:3306/ssafydb?serverTimezone=UTC&useUniCode=yes&characterEncoding=UTF-8",
				    		   "ssafy","ssafy");
		System.out.println("DB연결성공!!");
	   }catch(Exception e) {
	    }finally {
		   if(conn != null) conn.close();
	    }
	}//testConnection	
}




