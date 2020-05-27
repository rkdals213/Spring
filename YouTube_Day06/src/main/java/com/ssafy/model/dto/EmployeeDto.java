package com.ssafy.model.dto;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	private int id;
	private String name;
	private String mailid;
	private Date startdate;
	private int managerid;
	private String title;
	private int deptid;
	private int salary;
	private int commissionpct;
	private Dept dept;
}
