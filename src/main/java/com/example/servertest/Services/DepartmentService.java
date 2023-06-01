package com.example.servertest.Services;

import com.example.servertest.Entities.Department;
import com.example.servertest.Repositories.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }
    public List<Department> getDepartments(){
        return departmentRepo.findAll();
    }

    public void saveDepartment(Department department){
        departmentRepo.save(department);
    }
}
