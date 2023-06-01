package com.example.servertest.Services;

import com.example.servertest.Entities.Employee;
import com.example.servertest.Repositories.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public List<Employee> getEmployees(){
        System.out.println(employeeRepo.findAll().toString());
        return employeeRepo.findAll();
    }

    public void saveEmployee(Employee employee){
        employeeRepo.save(employee);
    }
}
