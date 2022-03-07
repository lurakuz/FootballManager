package com.demo.footballmanager.models.dtos;

import lombok.Data;

@Data
public class PlayerDto {

    Long id;
    Integer age;
    String lastName;
    String firstName;
    String careerStartDate;

    Long teamId;
}
