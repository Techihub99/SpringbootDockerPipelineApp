package com.org.java.controller;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.org.java.dto.EmployeeDto;
import com.org.java.entity.Employee;
import com.org.java.service.EmployeeService;

@RestController
@RequestMapping("/employee")
@SuppressWarnings({ "rawtypes", "unchecked" })
public class EmployeeController {
	Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/welcome")
	public String welcomeTest() {
		logger.trace("it is trace method welcome calling");
		logger.info("wel come method is working");
		return "WELCOME TO SPRING BOOT APPLICATION INTEGRATION WITH TOMCAT BY USING JENKINS PIPELINE BY USER NEW ADDED IS TECHI";
	}

	@PostMapping("/save")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		logger.info("start for save the data");
		Employee emp = employeeService.saveEmployeeDetails(employee);
		return new ResponseEntity("Sucessfully saved in to a Db", HttpStatus.CREATED);
	}

	@PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.updateEmployeeDetails(employee);
		return new ResponseEntity("Sucessfully updated fields in  DB", HttpStatus.CREATED);

	}

	@DeleteMapping("/delete")
	public ResponseEntity<Employee> deletEmployee(@RequestBody Employee employee) {
		Employee emp = employeeService.deleteEmployeeDetails(employee);
		return new ResponseEntity("Sucessfully deleted from DB", HttpStatus.NO_CONTENT);

	}

	@GetMapping("/findById/{empId}")
	public ResponseEntity<Employee> findByEmployeeId(@PathVariable("empId") int empId) {
		Optional<Employee> emplist = employeeService.findByEmployeeIdDeatails(empId);
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findByName/{empName}")
	public ResponseEntity<Employee> findByEmployeName(@PathVariable("empName") String empName) {
		List<Employee> emplist = employeeService.findByEmployeNameDeatails(empName);
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findByName")
	public ResponseEntity<Employee> findByEmployeNameQp(
			@RequestParam(value = "name", required = false) String empName) {
		List<Employee> emplist = employeeService.findByEmployeNameDeatails(empName);
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findByDepatmentName/{deptName}")
	public ResponseEntity<Employee> findByDeptDetails(@PathVariable("deptName") String deptName) {
		List<Employee> deptDetails = employeeService.findByDepartmentDetails(deptName);
		return new ResponseEntity(deptDetails, HttpStatus.OK);

	}

	@GetMapping("/findByDeptName/{deptName}")
	public ResponseEntity<Employee> findByEmployedeptName(@PathVariable("deptName") String deptName) {
		List<Employee> emplist = employeeService.findByEmployedeptNameDeatails(deptName);
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findByNameAndDeptName/{empName}/{deptName}")
	public ResponseEntity<Employee> findByNameAndDeptName(@PathVariable("empName") String empName,
			@PathVariable("deptName") String deptName) {
		Employee emplist = employeeService.findByNameAndDeptNameDeatails(empName, deptName);
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findByEmpIdAndNameAndDeptName/{empId}/{empName}/{deptName}")
	public ResponseEntity<Employee> findByEmpIdAndNameAndDeptName(@PathVariable("empId") int empId,
			@PathVariable("empName") String empName, @PathVariable("deptName") String deptName) {
		Employee emplist = employeeService.findByEmpIdAndNameAndDeptNameDeatails(empId, empName, deptName);
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findBySalaryAsc")
	public ResponseEntity<Employee> findByEmployeeAscSalary() {
		List<Employee> emplist = employeeService.findByEmployeeSalaryAscDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findBySalaryDsc")
	public ResponseEntity<Employee> findByEmployeeDscSalary() {
		List<Employee> emplist = employeeService.findByEmployeeSalaryDscDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findByBetwenSalary")
	public ResponseEntity<Employee> findByEmployeeBetweenSalary() {
		List<EmployeeDto> emplist = employeeService.findByEmployeeBetweenSalaryDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/groupCount")
	public ResponseEntity<Employee> findBygroupCount() {
		Map<String, Long> emplist = employeeService.findBygroupCountDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findByEvenNumber")
	public ResponseEntity<Employee> findByEmployeeIdEven() {
		List<Employee> emplist = employeeService.findByEmployeeIdEvenDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findByOddNumber")
	public ResponseEntity<Employee> findByEmployeeIdOdd() {
		List<Employee> emplist = employeeService.findByEmployeeIdOddDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/MaxSalary")
	public ResponseEntity<Employee> findByMaxSalary() {
		Employee emplist = employeeService.findByMaxSalaryDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/SecondHigestSalary")
	public ResponseEntity<Employee> SecondHigestSalary() {
		Employee secondHigestSalary = employeeService.secondHigestSalaryDeatails();
		return new ResponseEntity(secondHigestSalary, HttpStatus.OK);
	}

	@GetMapping("/SecondListSalary")
	public ResponseEntity<Employee> SecondListSalary() {
		Employee secondListSalary = employeeService.secondListSalaryDeatails();
		return new ResponseEntity(secondListSalary, HttpStatus.OK);
	}

	@GetMapping("/MinSalary")
	public ResponseEntity<Employee> findByMinSalary() {
		Employee emplist = employeeService.findByMinSalaryDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/SumSalary")
	public ResponseEntity<Employee> findBySumSalary() {
		double emplist = employeeService.findBySumSalaryDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/CountSalary")
	public ResponseEntity<Employee> findByCountSalary() {
		double emplist = employeeService.findByCountSalaryDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findParticularRecords")
	public ResponseEntity<Employee> findParticularRecords() {
		List<Employee> emplist = employeeService.findParticularRecordsDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findParticularFilters")
	public ResponseEntity<Employee> findParticularfilters() {
		List<Employee> empFilterlist = employeeService.findParticularRecordFileter();
		return new ResponseEntity(empFilterlist, HttpStatus.OK);
	}

	@GetMapping("/findParticularRecordsAsc")
	public ResponseEntity<Employee> findParticularRecordsAsc() {
		List<Employee> emplist = employeeService.findParticularRecordsAscsDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findParticularRecordsDsc")
	public ResponseEntity<Employee> findParticularRecordsDsc() {
		List<Employee> emplist = employeeService.findParticularRecordsDscDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/printDublicateRecordsInList")
	public ResponseEntity<Employee> printDublicateRecords() {
		Set<Employee> emplist = employeeService.printDublicateRecordsDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/printDublicatesInString")
	public ResponseEntity<Employee> printDublicatesInString() {
		List<String> dublicates = employeeService.printDublicatesInStringDeatails();
		return new ResponseEntity(dublicates, HttpStatus.OK);
	}

	@GetMapping("/printwithoutDublicateRecordsInList")
	public ResponseEntity<Employee> printWithoutDublicateRecords() {
		Set<Employee> emplist = employeeService.printWithoutDublicateRecordsDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/uniquerecordsInString")
	public ResponseEntity<Employee> uniquerecordsInString() {
		List<String> dublicates = employeeService.uniquerecordsInStringDeatails();
		return new ResponseEntity(dublicates, HttpStatus.OK);
	}

	@GetMapping("/mapNames")
	public ResponseEntity<Employee> mapNames() {
		List<String> emplist = employeeService.mapNamesDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/mapNamesToUpperCase")
	public ResponseEntity<Employee> mapNamesToUpperCase() {
		List<String> emplist = employeeService.mapNamesToUppercaseDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/findStringOccurence")
	public ResponseEntity<Employee> findStringOccurence() {
		Map<Character, Integer> emplist = employeeService.findStringOccurenceDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/groupBySalary")
	public ResponseEntity<Employee> groupBySalary() {
		Map<Object, List<Employee>> emplist = employeeService.groupBySalaryDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/groupByNames")
	public ResponseEntity<Employee> groupByNames() {
		Map<Object, List<Employee>> emplist = employeeService.groupByNamesDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/indexRanges/{fromIndex}/{toIndex}")
	public ResponseEntity<Employee> indexRanges(@PathVariable("fromIndex") int fromIndex,
			@PathVariable("toIndex") int toIndex) {
		List<Employee> emplist = employeeService.indexRangesDeatails(fromIndex, toIndex);
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/firstnonRepeactedCharacterInString")
	public ResponseEntity<Employee> firstnonRepeactedCharacterInString() {
		String emplist = employeeService.firstnonRepeactedCharacterInStringDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/firstRepeactedCharacterInString")
	public ResponseEntity<Employee> firstRepeactedCharacterInString() {
		String emplist = employeeService.firstRepeactedCharacterInStringDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/longestString")
	public ResponseEntity<Employee> longestString() {
		String emplist = employeeService.longestStringDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/leftRotationString")
	public ResponseEntity<Employee> leftRotationString() {
		String emplist = employeeService.leftRotationStringDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/rightRotationString")
	public ResponseEntity<Employee> rightRotationString() {
		String emplist = employeeService.rightRotationStringDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/smallestString")
	public ResponseEntity<Employee> smallestString() {
		String emplist = employeeService.smallestStringDeatails();
		return new ResponseEntity(emplist, HttpStatus.OK);
	}

	@GetMapping("/filterDepartmentIds")
	public ResponseEntity<Employee> filterDepartmentIds() {
		List<String> deptIds = employeeService.filterDepartmentIdsDeatails();
		return new ResponseEntity(deptIds, HttpStatus.OK);
	}

	@GetMapping("/stringReverseJava8")
	public ResponseEntity<Employee> stringReverseJava8() {
		String reverse = employeeService.stringReverseJava8Deatails();
		return new ResponseEntity(reverse, HttpStatus.OK);
	}

	@GetMapping("/joiningNames")
	public ResponseEntity<Employee> joiningNames() {
		String names = employeeService.joiningNamesDeatails();
		return new ResponseEntity(names, HttpStatus.OK);
	}

	@GetMapping("/listToSetConversion")
	public ResponseEntity<Employee> listToSetConversion() {
		Set<Employee> listToSetConversion = employeeService.listToSetCoversion();
		return new ResponseEntity(listToSetConversion, HttpStatus.OK);
	}

	@GetMapping("/listToMapConversion")
	public ResponseEntity<Employee> listToMapConversion() {
		Map<Integer, Employee> listToMapConversion = employeeService.listToMapCoversion();
		return new ResponseEntity(listToMapConversion, HttpStatus.OK);
	}

	@GetMapping("/setToListConversion")
	public ResponseEntity<Employee> setToListConversion() {
		List<Employee> setToListConversion = employeeService.setToListConversion();
		return new ResponseEntity(setToListConversion, HttpStatus.OK);
	}

	@GetMapping("/setToMapConversion")
	public ResponseEntity<Employee> setToMapConversion() {
		Map<Integer, Employee> setToMapConversion = employeeService.setToMapConversionDetails();
		return new ResponseEntity(setToMapConversion, HttpStatus.OK);
	}

	@GetMapping("/mapToListConversion")
	public ResponseEntity<Employee> mapToListConversion() {
		List<Entry<Integer, Employee>> mapToListConversion = employeeService.mapToListConversionDetails();
		return new ResponseEntity(mapToListConversion, HttpStatus.OK);
	}

	@GetMapping("/mapToSetConversion")
	public ResponseEntity<Employee> mapToSetConversion() {
		Set<Entry<Integer, Employee>> mapToSetConversion = employeeService.mapToSetConversionDetails();
		return new ResponseEntity(mapToSetConversion, HttpStatus.OK);
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Employee>> findAllEmployess() {
		logger.info("satart for getting the data getting the data");
		List<Employee> emplist = employeeService.findAllEmployeeDetails();
		logger.info("sucessfully getting the data");
		return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);

	}
}
