package com.demo.footballmanager.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageableTeamDto {

    private List<TeamDto> teams;
    private Long totalCount;
}
