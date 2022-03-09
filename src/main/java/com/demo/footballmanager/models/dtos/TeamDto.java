package com.demo.footballmanager.models.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class TeamDto {

    Long id;

    String city;
    String country;
    String teamName;

    Integer transferCommission;
    Double accountAmount;

    List<Long> playerIds;
}
