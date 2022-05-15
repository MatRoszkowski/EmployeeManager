package com.mateuszroszkowski.EmployeeManager.mapper;

import com.mateuszroszkowski.EmployeeManager.dto.EmployeeDto;
import com.mateuszroszkowski.EmployeeManager.model.Employee;
import org.springframework.stereotype.Component;

@Component
public class EmployeeMapper {
    public EmployeeDto map(Employee employee) {
        return EmployeeDto.builder()
                .id(employee.getId())
                .name(employee.getName())
                .email(employee.getEmail())
                .jobTitle(employee.getJobTitle())
                .phone(employee.getPhone())
                .imageUrl(employee.getImageUrl())
                .active(employee.isActive())
                .build();
    }

    public Employee map(EmployeeDto employeeDto) {
        return Employee.builder()
                .id(employeeDto.getId())
                .name(employeeDto.getName())
                .email(employeeDto.getEmail())
                .jobTitle(employeeDto.getJobTitle())
                .phone(employeeDto.getPhone())
                .imageUrl(employeeDto.getImageUrl())
                .active(employeeDto.isActive())
                .build();
    }
}
