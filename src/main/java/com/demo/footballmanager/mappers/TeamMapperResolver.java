package com.demo.footballmanager.mappers;

import com.demo.footballmanager.models.dtos.TeamDto;
import com.demo.footballmanager.models.entities.Player;
import com.demo.footballmanager.models.entities.Team;
import com.demo.footballmanager.services.PlayerService;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@AllArgsConstructor
public class TeamMapperResolver {

    private final PlayerService playerService;
    private final PlayerMapper playerMapper;

    @ObjectFactory
    Team resolve(TeamDto teamDto) {
        Team team = new Team();
        if (Objects.nonNull(teamDto) && Objects.nonNull(teamDto.getPlayerIds())) {
            List<Player> players = teamDto.getPlayerIds().stream()
                    .map(playerService::getPlayerById)
                    .map(playerMapper::map)
                    .collect(Collectors.toList());
            team.setPlayers(players);
        }
        return team;
    }
}
