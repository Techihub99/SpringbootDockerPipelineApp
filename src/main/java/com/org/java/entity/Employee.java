package com.org.java.entity;

import java.util.Date;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class Employee {

	@Id
	@GeneratedValue
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
