package com.demo.footballmanager.services;

import com.demo.footballmanager.exeptions.EntityNotFoundException;
import com.demo.footballmanager.exeptions.FootballManagerValidationException;
import com.demo.footballmanager.mappers.PlayerMapper;
import com.demo.footballmanager.models.dtos.PageablePlayerDto;
import com.demo.footballmanager.models.dtos.PlayerDto;
import com.demo.footballmanager.models.dtos.TransferDetailsDto;
import com.demo.footballmanager.models.entities.Player;
import com.demo.footballmanager.models.entities.Team;
import com.demo.footballmanager.repository.PlayerRepository;
import com.demo.footballmanager.repository.TeamRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@RequiredArgsConstructor
public class PlayerServiceImpl implements PlayerService {

    private final TeamRepository teamRepository;
    private final PlayerMapper playerMapper;
    private final PlayerRepository playerRep;

    @Override
    public List<PlayerDto> getAllPlayers() {
        log.info("Fetching all players");
        var players = (List<Player>) playerRep.findAll();
        log.info("Fetched all players. size = {}", players.size());
        return playerMapper.map(players);
    }

    @Override
    public PageablePlayerDto getAllPlayersPageable(Pageable pageable) {
        log.info("Fetching {} players", pageable.getPageSize());
        var page = playerRep.findAll(pageable);
        log.info("Fetched teams page. Size {}", page.getTotalPages());
        return new PageablePlayerDto(playerMapper.map(page.getContent()), page.getTotalElements());
    }

    @Override
    public PageablePlayerDto getAllPlayersByIds(List<Long> ids, Pageable pageable) {
        log.info("Fetching {} players", pageable.getPageSize());
        var page = playerRep.findByIds(ids, pageable);
        log.info("Fetched players page. Size {}", page.getTotalPages());
        return new PageablePlayerDto(playerMapper.map(page.getContent()), page.getTotalElements());
    }

    @Override
    public PlayerDto getPlayerById(Long playerId) {
        log.info("Fetching player by id");
        var player = findPlayer(playerId);
        log.info("Fetched player by id. player = {}", player);
        return playerMapper.map(player);
    }

    @Override
    public PlayerDto savePlayer(PlayerDto playerDto) {
        log.info("Saving player");
        var savedPlayer = playerRep.save(playerMapper.map(playerDto));
        log.info("Player is saved. player = {}", savedPlayer);
        return playerMapper.map(savedPlayer);
    }

    @Override
    public PlayerDto updatePlayer(PlayerDto playerDto) {
        validatePlayerExistence(playerDto.getId());
        log.info("Updating player");
        var player = playerMapper.map(playerDto);

        if (Objects.nonNull(playerDto.getTeamId()))
            transferPlayer(new TransferDetailsDto(playerDto.getTeamId(), playerDto.getId()));

        var savedPlayer = playerRep.save(player);
        log.info("Player is updated. Updated player = {}", savedPlayer);
        return playerMapper.map(savedPlayer);
    }

    @Override
    public void deletePlayer(Long id) {
        validatePlayerExistence(id);
        log.info("Deleting player");
        playerRep.deleteById(id);
        log.info("Player is deleted. playerId = {}", id);
    }

    @Override
    public PlayerDto transferPlayer(TransferDetailsDto transferDetails) {
        log.info("Fetching player by id");
        var player = findPlayer(transferDetails.getPlayerId());
        log.info("Fetched player by id. player = {}", player);
        var oldTeam = player.getTeam();

        log.info("Fetching player's new team by id");
        var newTeam = teamRepository.findById(transferDetails.getTeamId())
                .orElseThrow(() -> new EntityNotFoundException(Team.class, "id", transferDetails.getTeamId().toString()));
        log.info("Fetched team by id. team = {}", newTeam);

        var fullPrice = calculatingTransferAmount(player, oldTeam);

        if (newTeam.getAccountAmount() < fullPrice)
            throw new FootballManagerValidationException("Not enough money to transfer player!");

        log.info("Transferring player");
        oldTeam.setAccountAmount(oldTeam.getAccountAmount() + fullPrice);
        teamRepository.save(oldTeam);
        newTeam.setAccountAmount(newTeam.getAccountAmount() - fullPrice);
        player.setTeam(newTeam);

        var transferredPlayer = playerRep.save(player);
        log.info("Player ({} {}) is transferred to {}", transferredPlayer.getFirstName(), transferredPlayer.getLastName(),
                newTeam.getTeamName());
        return playerMapper.map(transferredPlayer);
    }

    @Override
    public Player findPlayer(Long playerId) {
        return playerRep.findById(playerId)
                .orElseThrow(() -> new EntityNotFoundException(Player.class, "id", playerId.toString()));
    }

    @Override
    public void validatePlayerExistence(Long playerId) {
        log.info("Validating player existence by id");
        if (!playerRep.existsById(playerId))
            throw new EntityNotFoundException(Player.class, "id", playerId.toString());
    }

    @Override
    public int calculatingTransferAmount(Player player, Team oldTeam){
        log.info("Calculating transfer amount");
        LocalDate today = LocalDate.now();
        Period age = Period.between(player.getCareerStartDate(), today);
        int months = age.getMonths();
        int transferPrice = months * 100000 / player.getAge();
        int commission = transferPrice / oldTeam.getTransferCommission();
        return transferPrice + commission;
    }
}
