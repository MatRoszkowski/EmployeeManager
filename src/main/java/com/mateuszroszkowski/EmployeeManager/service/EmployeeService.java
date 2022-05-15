package com.mateuszroszkowski.EmployeeManager.service;

import com.mateuszroszkowski.EmployeeManager.dto.EmployeeDto;
import com.mateuszroszkowski.EmployeeManager.model.JobTitle;

import java.util.List;

public interface EmployeeService {
    List<EmployeeDto> getAllEmployees();

    EmployeeDto addEmployee(EmployeeDto employeeDto);

    Boolean deleteEmployee(Long id);

    EmployeeDto updateEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long id);

    List<EmployeeDto> getEmployeesByJobTitle(JobTitle jobTitle);

    void deactivate(Long id);
}
