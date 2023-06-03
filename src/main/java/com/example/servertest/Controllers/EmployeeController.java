package com.example.servertest.Controllers;

import com.example.servertest.DTOs.DepartmentDTO;
import com.example.servertest.DTOs.EmployeeDTO;
import com.example.servertest.Entities.Department;
import com.example.servertest.Entities.Employee;
import com.example.servertest.Exception_handling.NoSuchEntityException;
import com.example.servertest.Mappers.EmployeeMapper;
import com.example.servertest.Services.EmployeeService;
import org.mapstruct.factory.Mappers;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    @GetMapping(value = "/employees/{id}")
    public EmployeeDTO getEmployee(@PathVariable int id){
        Optional<Employee> employee = employeeService.getEmployee(id);
        if (employee.isEmpty()){
            throw new NoSuchEntityException("There is no employee with ID = " + id + " in Database");
        }
        return employeeMapper.employeeToEmployeeDTO(employee.get());
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
    @DeleteMapping(value = "/employees/{id}")
    @ResponseBody
    public String deleteEmployee(@PathVariable int id){
        employeeService.deleteEmployee(id);
        return "successful";
    }
}