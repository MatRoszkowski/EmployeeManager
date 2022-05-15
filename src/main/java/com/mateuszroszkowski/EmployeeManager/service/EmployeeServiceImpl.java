package com.mateuszroszkowski.EmployeeManager.service;

import com.mateuszroszkowski.EmployeeManager.dto.EmployeeDto;
import com.mateuszroszkowski.EmployeeManager.mapper.EmployeeMapper;
import com.mateuszroszkowski.EmployeeManager.model.Employee;
import com.mateuszroszkowski.EmployeeManager.model.JobTitle;
import com.mateuszroszkowski.EmployeeManager.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final EmployeeMapper employeeMapper;

    public List<EmployeeDto> getAllEmployees() {
        List<EmployeeDto> employeesDto;
        List<Employee> employees = employeeRepository.findAll();
        employeesDto = employees.stream().map(employee -> employeeMapper.map(employee)).collect(Collectors.toList());
        return employeesDto;
    }

    public EmployeeDto addEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeMapper.map(employeeDto);
        employeeDto = employeeMapper.map(employeeRepository.save(employee));
        return employeeDto;
    }

    public Boolean deleteEmployee(Long id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public EmployeeDto updateEmployee(EmployeeDto employeeDto) {
        Employee employee = employeeRepository.getById(employeeDto.getId());
        employee.setName(employeeDto.getName());
        employee.setEmail(employeeDto.getEmail());
        employee.setJobTitle(employeeDto.getJobTitle());
        employee.setPhone(employeeDto.getPhone());
        employee.setImageUrl(employeeDto.getImageUrl());
        return employeeMapper.map(employeeRepository.save(employee));
    }

    public EmployeeDto getEmployeeById(Long id) {
        return employeeMapper.map(employeeRepository.getById(id));
    }

    @Override
    public List<EmployeeDto> getEmployeesByJobTitle(JobTitle jobTitle) {
        List<EmployeeDto> employeeDtoList = employeeRepository.findByJobTitle(jobTitle)
                .stream().map(employee -> employeeMapper.map(employee))
                .collect(Collectors.toList());
        return employeeDtoList;
    }

    @Override
    public void deactivate(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isPresent()){
            employee.get().setActive(false);
        }else {
            throw new RuntimeException("Employee not found");
        }
    }
}
