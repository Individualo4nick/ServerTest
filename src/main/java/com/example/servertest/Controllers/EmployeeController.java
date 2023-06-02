package com.example.servertest.Controllers;

import com.example.servertest.DTOs.EmployeeDTO;
import com.example.servertest.Entities.Employee;
import com.example.servertest.Mappers.EmployeeMapper;
import com.example.servertest.Services.EmployeeService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class EmployeeController {
    private final EmployeeService employeeService;
    private final EmployeeMapper employeeMapper = Mappers.getMapper(EmployeeMapper.class);
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(value = "/employees")
    public List<EmployeeDTO> getEmployees(){
        List<Employee> employees = employeeService.getEmployees();
        return (List<EmployeeDTO>) employeeMapper.arrayEmployeeToArrayEmployee(employees);
    }
    @PostMapping(value = "/employees")
    public EmployeeDTO createDepartment(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employeeMapper.employeeToEmployeeDTO(employee);
    }
    @PutMapping(value = "/employees")
    public EmployeeDTO updateEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
        return employeeMapper.employeeToEmployeeDTO(employee);
    }
}