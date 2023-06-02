package com.example.servertest.Mappers;

import com.example.servertest.DTOs.DepartmentDTO;
import com.example.servertest.DTOs.EmployeeDTO;
import com.example.servertest.Entities.Department;
import com.example.servertest.Entities.Employee;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.ArrayList;
import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Mapping(target = "employees", source = "employees")
    DepartmentDTO departmentToDepartmentDTO(Department department);
    default List<EmployeeDTO> map(List<Employee> field) {
        ArrayList<EmployeeDTO> employeesDTO = new ArrayList<EmployeeDTO>();
        for (Employee employee : field) {
            employeesDTO.add(new EmployeeDTO()
                    .setId(employee.getId())
                    .setName(employee.getName())
                    .setPosition(employee.getPosition())
                    .setSalary(employee.getSalary())
                    .setDepartmentName(employee.getDepartment().getName()));
        }
        return employeesDTO;
    }
    @IterableMapping(elementTargetType = DepartmentDTO.class)
    Iterable<DepartmentDTO> arrayDepartmentToArrayDepartment(Iterable<Department> departments);
}