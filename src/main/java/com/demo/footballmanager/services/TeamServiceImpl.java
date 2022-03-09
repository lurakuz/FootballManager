package com.demo.footballmanager.services;

import com.demo.footballmanager.exeptions.EntityNotFoundException;
import com.demo.footballmanager.mappers.TeamMapper;
import com.demo.footballmanager.models.dtos.PageableTeamDto;
import com.demo.footballmanager.models.dtos.TeamDto;
import com.demo.footballmanager.models.entities.Team;
import com.demo.footballmanager.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRep;
    private final TeamMapper teamMapper;

    @Override
    public List<TeamDto> getAllTeams() {
        log.info("Fetching all teams");
        var teams = (List<Team>) teamRep.findAll();
        log.info("Fetched all teams. Size {}", teams.size());
        return teamMapper.map(teams);
    }

    @Override
    public PageableTeamDto getAllTeamsPageable(Pageable pageable) {
        log.info("Fetching {} teams", pageable.getPageSize());
        var page = teamRep.findAll(pageable);
        log.info("Fetched teams page. Size {}", page.getTotalPages());
        return new PageableTeamDto(teamMapper.map(page.getContent()), page.getTotalElements());
    }

    @Override
    public TeamDto getTeamById(Long teamId) {
        log.info("Fetching team by id");
        var team = teamRep.findById(teamId)
                .orElseThrow(() -> new EntityNotFoundException(Team.class, "id", teamId.toString()));
        log.info("Team is fetched. Team = {}", team);
        return teamMapper.map(team);
    }

    @Override
    public TeamDto saveTeam(TeamDto teamDto) {
        log.info("Creating team");
        if(teamDto.getTransferCommission()>10){teamDto.setTransferCommission(10);}
        var savedTeam = teamRep.save(teamMapper.map(teamDto));
        log.info("Team is created. Team = {}", savedTeam);
        return teamMapper.map(savedTeam);
    }

    @Override
    public TeamDto updateTeam(TeamDto teamDto) {
        validateTeamExistence(teamDto.getId());
        log.info("Updating team");
        if(teamDto.getTransferCommission()>10){teamDto.setTransferCommission(10);}
        var updatedTeam = teamRep.save(teamMapper.map(teamDto));
        log.info("Team is updated. Updated team = {}", updatedTeam);
        return teamMapper.map(updatedTeam);
    }

    @Override
    public void deleteTeam(Long id) {
        validateTeamExistence(id);
        log.info("Deleting team");
        teamRep.deleteById(id);
        log.info("Team is deleted. teamId = {}", id);
    }

    @Override
    public void validateTeamExistence(Long id) {
        log.info("Validating team existence by id");
        if (!teamRep.existsById(id))
            throw new EntityNotFoundException(Team.class, "id", id.toString());
    }
}

