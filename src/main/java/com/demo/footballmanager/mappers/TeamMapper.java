package com.demo.footballmanager.mappers;

import com.demo.footballmanager.models.dtos.TeamDto;
import com.demo.footballmanager.models.entities.Player;
import com.demo.footballmanager.models.entities.Team;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {TeamMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeamMapper {

    TeamDto map(Team team);

    Team map(TeamDto teamDto);

    List<TeamDto> map(List<Team> teams);

    @AfterMapping
    default void mapPlayerIds(@MappingTarget TeamDto teamDto, Team team) {
        if (teamDto.getPlayerIds() == null){
            teamDto.setPlayerIds(null);
        } else {
            teamDto.setPlayerIds(team.getPlayers().stream().map(Player::getId).collect(Collectors.toList()));
        }
    }
}
