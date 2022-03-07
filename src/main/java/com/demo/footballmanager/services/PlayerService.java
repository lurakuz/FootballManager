package com.demo.footballmanager.services;

import com.demo.footballmanager.models.dtos.PageablePlayerDto;
import com.demo.footballmanager.models.dtos.PlayerDto;
import com.demo.footballmanager.models.dtos.TransferDetailsDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PlayerService {

    List<PlayerDto> getAllPlayers();

    PageablePlayerDto getAllPlayersPageable(Pageable pageable);

    PageablePlayerDto getAllPlayersByIds(List<Long> ids, Pageable pageable);

    PlayerDto getPlayerById(Long id);

    PlayerDto updatePlayer(PlayerDto player);

    PlayerDto savePlayer(PlayerDto player);

    void deletePlayer(Long id);

    PlayerDto transferPlayer(TransferDetailsDto transferDetails);
}
