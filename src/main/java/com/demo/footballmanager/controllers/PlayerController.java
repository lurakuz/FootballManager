package com.demo.footballmanager.controllers;

import com.demo.footballmanager.exeptions.EntityNotFoundException;
import com.demo.footballmanager.models.dtos.PageablePlayerDto;
import com.demo.footballmanager.models.dtos.PlayerDto;
import com.demo.footballmanager.models.dtos.TransferDetailsDto;
import com.demo.footballmanager.services.PlayerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@AllArgsConstructor
@RequestMapping("/players")
@CrossOrigin(origins = "http://localhost:4200")
public class PlayerController {

    private static final String LOG_MESSAGE = "Endpoint - {}() call";

    private final PlayerService playerService;

    @GetMapping()
    public ResponseEntity<List<PlayerDto>> getAllPlayers() {
        log.info(LOG_MESSAGE, "getAllPlayers");
        List<PlayerDto> players = playerService.getAllPlayers();
        return ResponseEntity.ok(players);
    }

    @GetMapping("/pageable")
    public ResponseEntity<PageablePlayerDto> getAllPlayersPageable(@PageableDefault(size = 5) Pageable pageable) {
        log.info(LOG_MESSAGE, "getAllPlayersPageable");
        PageablePlayerDto pageablePlayerDto = playerService.getAllPlayersPageable(pageable);
        return ResponseEntity.ok(pageablePlayerDto);
    }

    @PostMapping("/ids")
    public ResponseEntity<PageablePlayerDto> getAllPlayersByIds(@RequestBody List<Long> ids,
                                                                @PageableDefault(size = 5) Pageable pageable) {
        log.info(LOG_MESSAGE, "getAllPlayersByIds");
        return ResponseEntity.ok(playerService.getAllPlayersByIds(ids, pageable));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PlayerDto> getPlayerById(@PathVariable Long id) throws EntityNotFoundException {
        log.info(LOG_MESSAGE, "getPlayerById");
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @PostMapping
    public ResponseEntity<PlayerDto> createPlayer(@RequestBody PlayerDto playerDto) {
        log.info(LOG_MESSAGE, "createPlayer");
        return ResponseEntity.ok(playerService.savePlayer(playerDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayerById(@PathVariable Long id, @RequestBody PlayerDto playerDto)
            throws EntityNotFoundException {
        log.info(LOG_MESSAGE, "updatePlayerById");
        playerDto.setId(id);
        return ResponseEntity.ok(playerService.updatePlayer(playerDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deletePlayerById(@PathVariable Long id) throws EntityNotFoundException {
        log.info(LOG_MESSAGE, "deletePlayerById");
        playerService.deletePlayer(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }

    @GetMapping("/transfer-player/{id}")
    public ResponseEntity<PlayerDto> transferPlayerPage(@PathVariable Long id)
            throws EntityNotFoundException{
        log.info(LOG_MESSAGE, "transferPlayerInfo");
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @PostMapping("/transfer-player/{id}")
    public ResponseEntity<PlayerDto> transferPlayer(@RequestBody TransferDetailsDto transferDetails) {
        log.info(LOG_MESSAGE, "transferPlayer");
        return ResponseEntity.ok(playerService.transferPlayer(transferDetails));
    }
}