package com.mateuszroszkowski.EmployeeManager;

import com.mateuszroszkowski.EmployeeManager.dto.EmployeeDto;
import com.mateuszroszkowski.EmployeeManager.model.Employee;
import com.mateuszroszkowski.EmployeeManager.model.JobTitle;
import com.mateuszroszkowski.EmployeeManager.repository.EmployeeRepository;
import com.mateuszroszkowski.EmployeeManager.service.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EmployeeManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmployeeManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(EmployeeService employeeService){
		return args -> {
			EmployeeDto employeeDto = EmployeeDto.builder()
					.name("Frank")
					.email("email")
					.phone("66666666666")
					.jobTitle(JobTitle.MANAGER)
					.imageUrl("urel")
					.build();
			EmployeeDto employeeDto1 = EmployeeDto.builder()
					.name("John")
					.email("email")
					.phone("66666666666")
					.jobTitle(JobTitle.DEVELOPER)
					.imageUrl("urel")
					.build();
			EmployeeDto employeeDto2 = EmployeeDto.builder()
					.name("Anna")
					.email("email")
					.phone("66666666666")
					.jobTitle(JobTitle.DEVELOPER)
					.imageUrl("urel")
					.build();
			EmployeeDto employeeDto3 = EmployeeDto.builder()
					.name("Ricky")
					.email("email")
					.phone("66666666666")
					.jobTitle(JobTitle.DEVELOPER)
					.imageUrl("urel")
					.build();
			employeeService.addEmployee(employeeDto);
			employeeService.addEmployee(employeeDto1);
			employeeService.addEmployee(employeeDto2);
			employeeService.addEmployee(employeeDto3);

		};
	}
}
