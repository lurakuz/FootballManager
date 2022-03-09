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

    public PlayerDto(Long id, Integer age, String lastName, String firstName, String careerStartDate, Long teamId) {
        this.id = id;
        this.age = age;
        this.lastName = lastName;
        this.firstName = firstName;
        this.careerStartDate = careerStartDate;
        this.teamId = teamId;
    }
}
