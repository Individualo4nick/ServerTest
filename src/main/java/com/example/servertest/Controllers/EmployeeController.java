package com.example.servertest.Controllers;

import com.example.servertest.Entities.Employee;
import com.example.servertest.Services.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }
    @GetMapping(value = "/employees")
    public List<Employee> getEmployees(){
        return employeeService.getEmployees();
    }
    @PostMapping(value = "/employees")
    public void createDepartment(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }
}