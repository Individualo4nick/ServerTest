package com.example.servertest.DTOs;

import com.example.servertest.Entities.Department;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
public class EmployeeDTO {
    public Integer id;
    public String name;
    public String position;
    public int salary;
    public String departmentName;
}
