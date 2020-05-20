package com.ssafy.day3.dto;

import java.util.Date;

public class Guest {
	private int no;
	private String writer;
	private String email;
	private String tel;
	private String pass;
	private String contents;
	private Date wdate;
	
    public Guest() {
	}

	public Guest(int no, String writer, String email, String tel, String pass, String contents, Date wdate) {
		super();
		this.no = no;
		this.writer = writer;
		this.email = email;
		this.tel = tel;
		this.pass = pass;
		this.contents = contents;
		this.wdate = wdate;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public Date getWdate() {
		return wdate;
	}

	public void setWdate(Date wdate) {
		this.wdate = wdate;
	}

	@Override
	public String toString() {
		return "Guest [no=" + no + ", writer=" + writer + ", email=" + email + ", tel=" + tel + ", pass=" + pass
				+ ", contents=" + contents + ", wdate=" + wdate + "]";
	}	
    
    
}
