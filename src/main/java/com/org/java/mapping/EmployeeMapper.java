package com.org.java.mapping;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.org.java.dto.EmployeeDto;
import com.org.java.entity.Employee;

@Mapper
public interface EmployeeMapper {
	EmployeeMapper INSTANCE = Mappers.getMapper(EmployeeMapper.class);

    Employee mapEmployeetDTOToEmployee(EmployeeDto employeeDto);
    EmployeeDto mapEmployeeToEmployeeDtp(Employee employee);

}
