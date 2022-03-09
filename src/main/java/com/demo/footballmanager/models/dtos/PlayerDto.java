package com.demo.footballmanager.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PlayerDto {

    Long id;
    Integer age;
    String lastName;
    String firstName;
    String careerStartDate;

    Long teamId;
}
