package com.mateuszroszkowski.EmployeeManager.repository;

import com.mateuszroszkowski.EmployeeManager.model.Employee;
import com.mateuszroszkowski.EmployeeManager.model.JobTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findByJobTitle(JobTitle jobTitle);
}
