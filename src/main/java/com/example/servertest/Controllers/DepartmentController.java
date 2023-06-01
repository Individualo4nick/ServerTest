package com.example.servertest.Controllers;

import com.example.servertest.Services.DepartmentService;
import com.example.servertest.Entities.Department;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class DepartmentController {

    private final DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(value = "/departments")
    public ResponseEntity<List<Department>> getDepartments(){
        return new ResponseEntity<>(departmentService.getDepartments(), HttpStatus.OK);
    }
    @PostMapping(value = "/departments")
    public void createDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
    }
}
