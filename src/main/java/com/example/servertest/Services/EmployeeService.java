package com.example.servertest.Services;

import com.example.servertest.Entities.Department;
import com.example.servertest.Entities.Employee;
import com.example.servertest.Repositories.EmployeeRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    private final EmployeeRepo employeeRepo;

    public EmployeeService(EmployeeRepo employeeRepo) {
        this.employeeRepo = employeeRepo;
    }
    public List<Employee> getEmployees(){
        return employeeRepo.findAll();
    }
    public void saveEmployee(Employee employee){
        employeeRepo.save(employee);
    }
    public void deleteEmployee(int id){
        employeeRepo.deleteById(id);
    }
    public Optional<Employee> getEmployee(int id){
        return employeeRepo.findById(id);
    }
}
