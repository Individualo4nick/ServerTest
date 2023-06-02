package com.example.servertest.Controllers;

import com.example.servertest.DTOs.DepartmentDTO;
import com.example.servertest.DTOs.EmployeeDTO;
import com.example.servertest.Entities.Employee;
import com.example.servertest.Mappers.DepartmentMapper;
import com.example.servertest.Mappers.EmployeeMapper;
import com.example.servertest.Services.DepartmentService;
import com.example.servertest.Entities.Department;
import org.mapstruct.factory.Mappers;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/server")
public class DepartmentController {

    private final DepartmentService departmentService;
    private final DepartmentMapper departmentMapper = Mappers.getMapper(DepartmentMapper.class);

    public DepartmentController(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    @GetMapping(value = "/departments")
    public ResponseEntity<List<DepartmentDTO>> getDepartments(){
        List<Department> departments = departmentService.getDepartments();
        List<DepartmentDTO> departmentsdto = (List<DepartmentDTO>) departmentMapper.arrayDepartmentToArrayDepartment(departments);
        return new ResponseEntity<>(departmentsdto, HttpStatus.OK);
    }
    @PostMapping(value = "/departments")
    public DepartmentDTO createDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return departmentMapper.departmentToDepartmentDTO(department);
    }

    @PutMapping(value = "/departments")
    @ResponseBody
    public String updateDepartment(@RequestBody Department department){
        departmentService.saveDepartment(department);
        return "Successful! To see the changes, refer to the get-method.";
    }
}
