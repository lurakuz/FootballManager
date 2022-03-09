package com.demo.footballmanager.services;

import com.demo.footballmanager.models.dtos.PageableTeamDto;
import com.demo.footballmanager.models.dtos.TeamDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface TeamService {

    List<TeamDto> getAllTeams();

    TeamDto getTeamById(Long id);

    TeamDto saveTeam(TeamDto team);

    TeamDto updateTeam(TeamDto team);

    void deleteTeam(Long id);

    PageableTeamDto getAllTeamsPageable(Pageable pageable);

    void validateTeamExistence(Long id);
}
