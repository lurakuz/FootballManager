package com.demo.footballmanager.controllers;

import com.demo.footballmanager.models.dtos.PageableTeamDto;
import com.demo.footballmanager.models.dtos.TeamDto;
import com.demo.footballmanager.services.TeamService;
import lombok.RequiredArgsConstructor;
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
@RequiredArgsConstructor
@RequestMapping("/teams")
@CrossOrigin(origins = "http://localhost:4200")
public class TeamController {

    private static final String LOG_MESSAGE = "Endpoint - {}() call";

    private final TeamService teamService;

    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams() {
        log.info(LOG_MESSAGE, "getAllTeams");
        return ResponseEntity.ok(teamService.getAllTeams());
    }

    @GetMapping("/pageable")
    public ResponseEntity<PageableTeamDto> getAllTeamsPageable(@PageableDefault(size = 5) Pageable pageable) {
        log.info(LOG_MESSAGE, "getAllTeams");
        return ResponseEntity.ok(teamService.getAllTeamsPageable(pageable));
    }


    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Long id) {
        log.info(LOG_MESSAGE, "getTeamById");
        return ResponseEntity.ok(teamService.getTeamById(id));
    }

    @PostMapping()
    public ResponseEntity<TeamDto> createTeam(@RequestBody TeamDto teamDto) {
        log.info(LOG_MESSAGE, "createTeam");
        return ResponseEntity.ok(teamService.saveTeam(teamDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TeamDto> updateTeamById(@PathVariable Long id, @RequestBody TeamDto teamDto) {
        log.info(LOG_MESSAGE, "updateTeamById");
        teamDto.setId(id);
        return ResponseEntity.ok(teamService.updateTeam(teamDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteTeamById(@PathVariable Long id) {
        log.info(LOG_MESSAGE, "deleteTeamById");
        teamService.deleteTeam(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);
    }
}