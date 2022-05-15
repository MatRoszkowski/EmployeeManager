package com.mateuszroszkowski.EmployeeManager.dto;

import com.mateuszroszkowski.EmployeeManager.model.JobTitle;
import lombok.Builder;
import lombok.Data;
import org.springframework.hateoas.RepresentationModel;

@Data
@Builder
public class EmployeeDto {
    private Long id;
    private String name;
    private String email;
    private JobTitle jobTitle;
    private String phone;
    private String imageUrl;
    private boolean active;
}
