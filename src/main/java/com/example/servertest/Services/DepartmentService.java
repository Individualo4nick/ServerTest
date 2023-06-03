package com.example.servertest.Services;

import com.example.servertest.Entities.Department;
import com.example.servertest.Repositories.DepartmentRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    private final DepartmentRepo departmentRepo;

    public DepartmentService(DepartmentRepo departmentRepo) {
        this.departmentRepo = departmentRepo;
    }
    public List<Department> getDepartments(){
        return departmentRepo.findAll();
    }
    public Optional<Department> getDepartment(int id){
        return departmentRepo.findById(id);
    }
    public void saveDepartment(Department department){
        departmentRepo.save(department);
    }
    public void deleteDepartment(int id){
        departmentRepo.deleteById(id);
    }
}
