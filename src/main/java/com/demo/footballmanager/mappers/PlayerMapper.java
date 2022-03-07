package com.demo.footballmanager.mappers;

import com.demo.footballmanager.models.dtos.PlayerDto;
import com.demo.footballmanager.models.entities.Player;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PlayerMapperResolver.class},
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlayerMapper {

    @Mapping(source = "team.id", target = "teamId")
    PlayerDto map(Player player);

    Player map(PlayerDto playerDto);

    List<PlayerDto> map(List<Player> players);

}