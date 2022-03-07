package com.demo.footballmanager.models.dtos;

import lombok.Data;

import java.util.List;

@Data
public class TeamDto {

    Long id;

    String city;
    String country;
    String teamName;

    Integer transferCommission;
    Double accountAmount;

    List<Long> playerIds;
}
