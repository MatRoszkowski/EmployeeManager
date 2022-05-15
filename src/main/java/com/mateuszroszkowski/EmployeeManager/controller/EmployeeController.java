package com.mateuszroszkowski.EmployeeManager.controller;

import com.mateuszroszkowski.EmployeeManager.dto.EmployeeDto;
import com.mateuszroszkowski.EmployeeManager.model.Employee;
import com.mateuszroszkowski.EmployeeManager.model.JobTitle;
import com.mateuszroszkowski.EmployeeManager.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(value = "/api/employees", produces = {MediaType.APPLICATION_JSON_VALUE})
@CrossOrigin(origins = "http://localhost:8080")
@AllArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping("/")
    public CollectionModel<EntityModel<EmployeeDto>> getAll() {
        List<EntityModel<EmployeeDto>> employeesDto = employeeService.getAllEmployees().stream()
                .map(employeeDto -> EntityModel.of(employeeDto)).collect(Collectors.toList());
        return CollectionModel.of(employeesDto,
                linkTo(methodOn(EmployeeController.class).getAll()).withSelfRel());
    }

    @PostMapping("/")
    public EntityModel<EmployeeDto> addEmployee(@RequestBody EmployeeDto employeeDto) {
        EmployeeDto employee = employeeService.addEmployee(employeeDto);
        return EntityModel.of(employee,
                linkTo(methodOn(EmployeeController.class).addEmployee(employeeDto)).withSelfRel(),
                linkTo(methodOn(EmployeeController.class).getAll()).withRel("getAll"),
                linkTo(methodOn(EmployeeController.class).getEmployeeById(employee.getId())).withRel("getById"));
    }

    @DeleteMapping("/{id}")
    public Boolean deleteEmployee(@PathVariable("id") Long id) {
        return employeeService.deleteEmployee(id);
    }

    @PutMapping("/")
    public EmployeeDto updateEmployee(@RequestBody EmployeeDto employeeDto) {
        return employeeService.updateEmployee(employeeDto);
    }

    @GetMapping("/{id}")
    public EmployeeDto getEmployeeById(@PathVariable("id") Long id) {
        return employeeService.getEmployeeById(id);
    }

    @GetMapping("/{jobTitle}")
    public List<EmployeeDto> getByJobTitle(@PathVariable JobTitle jobTitle) {
        List<EmployeeDto> employeeDtoList = employeeService.getEmployeesByJobTitle(jobTitle);
        return employeeDtoList;
    }

    @PutMapping("/{id}/deactivate")
    public void deactivate(@PathVariable("id") Long id) {
        employeeService.deactivate(id);
    }
}
