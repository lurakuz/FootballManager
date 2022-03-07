package com.demo.footballmanager.mappers;

import com.demo.footballmanager.models.dtos.PlayerDto;
import com.demo.footballmanager.models.entities.Player;
import com.demo.footballmanager.repository.TeamRepository;
import lombok.AllArgsConstructor;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class PlayerMapperResolver {

    final TeamRepository teamRepository;

    @ObjectFactory
    Player resolve(PlayerDto playerDto) {
        Player player = new Player();
        if (Objects.nonNull(playerDto) && Objects.nonNull(playerDto.getTeamId()))
            player.setTeam(teamRepository.findById(playerDto.getTeamId()).orElse(null));
        return player;
    }
}
