package com.example.servertest.Mappers;

import com.example.servertest.DTOs.EmployeeDTO;
import com.example.servertest.Entities.Department;
import com.example.servertest.Entities.Employee;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Mapping(target = "departmentName", source = "department")
    EmployeeDTO employeeToEmployeeDTO(Employee employee);
    default String map(Department field) {
        return field.getName();
    }
    @IterableMapping(elementTargetType = EmployeeDTO.class)
    Iterable<EmployeeDTO> arrayEmployeeToArrayEmployee(Iterable<Employee> employees);
}
