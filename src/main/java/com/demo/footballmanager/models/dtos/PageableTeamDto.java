package com.demo.footballmanager.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageableTeamDto {

    private List<TeamDto> teams;
    private Long totalCount;
}
