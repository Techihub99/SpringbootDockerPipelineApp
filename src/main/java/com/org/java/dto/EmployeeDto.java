package com.org.java.dto;

import java.util.Date;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDto {
	
	@Id
	private int empId;
	private String empName;
	private int age;
	private double salary;
	private String designation;
	private Date dataofJoinning;
	private String plateform;
	private String sector;
	private long mobbileNumber;
	private String email;
	private int departmentId;
	private String deptName;

}
