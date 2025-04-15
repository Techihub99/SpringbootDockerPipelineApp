package com.org.java.service;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.org.java.dto.EmployeeDto;

import com.org.java.entity.Employee;

@Service
public interface EmployeeService {

	Employee saveEmployeeDetails(Employee employee);

	List<Employee> findAllEmployeeDetails();

	Employee updateEmployeeDetails(Employee employee);

	Employee deleteEmployeeDetails(Employee employee);

	List<Employee> findByEmployeNameDeatails(String empName);

	List<Employee> findByEmployedeptNameDeatails(String deptName);

	List<Employee> findByEmployeeSalaryAscDeatails();

	List<Employee> findByEmployeeSalaryDscDeatails();

	List<Employee> findByEmployeeIdEvenDeatails();

	List<Employee> findByEmployeeIdOddDeatails();

	Employee findByMaxSalaryDeatails();

	Employee findByMinSalaryDeatails();

	double findBySumSalaryDeatails();

	double findByCountSalaryDeatails();

	List<Employee> findParticularRecordsDeatails();
	
	List<Employee> findParticularRecordFileter();

	Set<Employee> printDublicateRecordsDeatails();

	Set<Employee> printWithoutDublicateRecordsDeatails();

	List<Employee> findParticularRecordsAscsDeatails();

	List<Employee> findParticularRecordsDscDeatails();

	List<String> mapNamesDeatails();
	
	List<String> mapNamesToUppercaseDeatails();

	Map<Character, Integer> findStringOccurenceDeatails();

	Map<Object, List<Employee>> groupBySalaryDeatails();

	Map<Object, List<Employee>> groupByNamesDeatails();

	Employee findByNameAndDeptNameDeatails(String empName, String deptName);

	Employee findByEmpIdAndNameAndDeptNameDeatails(int empId, String empName, String deptName);

	String firstnonRepeactedCharacterInStringDeatails();

	String firstRepeactedCharacterInStringDeatails();

	List<String> printDublicatesInStringDeatails();

	List<String> uniquerecordsInStringDeatails();

	String longestStringDeatails();

	String smallestStringDeatails();

	List<String> filterDepartmentIdsDeatails();

	String stringReverseJava8Deatails();

	Employee secondHigestSalaryDeatails();

	Employee secondListSalaryDeatails();

	List<Employee> indexRangesDeatails(int fromIndex, int toIndex);

	String joiningNamesDeatails();

	Set<Employee> listToSetCoversion();

	Map<Integer, Employee> listToMapCoversion();

	List<Employee> setToListConversion();

	Map<Integer, Employee> setToMapConversionDetails();

	List<Entry<Integer, Employee>> mapToListConversionDetails();

	Set<Entry<Integer, Employee>> mapToSetConversionDetails();

	Optional<Employee> findByEmployeeIdDeatails(int empId);

	List<Employee> findByDepartmentDetails(String deptName);

	String leftRotationStringDeatails();

	String rightRotationStringDeatails();

	List<EmployeeDto> findByEmployeeBetweenSalaryDeatails();

	Map<String, Long> findBygroupCountDeatails();


}
