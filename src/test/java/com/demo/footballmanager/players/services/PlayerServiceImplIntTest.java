package com.demo.footballmanager.players.services;

import com.demo.footballmanager.mappers.PlayerMapper;
import com.demo.footballmanager.models.dtos.PlayerDto;
import com.demo.footballmanager.models.entities.Player;
import com.demo.footballmanager.models.entities.Team;
import com.demo.footballmanager.repository.PlayerRepository;
import com.demo.footballmanager.services.PlayerService;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerServiceImplIntTest {

    @InjectMocks
    PlayerService playerService;

    @Mock
    PlayerRepository playerRepository;

    @Mock
    PlayerMapper playerMapper;


    @Before("")
    public void init(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getAllPlayers() {

//        List<Player> list = new ArrayList<Player>();
//
//        Player player1 = new Player(1L, 37, "Ronaldo", "Cristiano",
//                LocalDate.of(1992, 1, 1), new Team());
//        Player player2 = new Player(2L, 20, "Greenwood", "Mason",
//                LocalDate.of(2017,2,2), new Team());
//        Player player3 = new Player(3L, 28, "Pogba", "Paul",
//                LocalDate.of(1999,3,3), new Team());
//
//        list.add(player1);
//        list.add(player2);
//        list.add(player3);
//
//        when(playerMapper.map(list)).thenReturn()
//        when(playerRepository.findAll()).thenReturn(list);
//
//        Team team = new Team(1L, "England", "Manchester", "Manchester United",
//                10000000.00, 3, list);
//
//        player1.setTeam(team);
//        player2.setTeam(team);
//        player3.setTeam(team);
//
//        //test
//        List<PlayerDto> playerList = playerService.getAllPlayers();
//
//        assertEquals(3, playerList.size());
//        verify(playerRepository, times(1)).findAll();
    }

    @Test
    void getAllPlayersPageable() {
    }

    @Test
    void getAllPlayersByIds() {
    }

    @Test
    void getPlayerById() {
    }

//    @Test
//    void savePlayer() {
//        PlayerDto player = new PlayerDto(1L, 37, "Ronaldo", "Cristiano", "1992-01-01", 1L);
//        playerService.savePlayer(player);
//        verify(playerRepository, times(1)).save(player);
//    }

    @Test
    void updatePlayer() {
    }

    @Test
    void deletePlayer() {
    }

    @Test
    void transferPlayer() {
    }

    @Test
    void findPlayer() {
    }

    @Test
    void validatePlayerExistence() {
    }

    @Test
    void calculatingTransferAmount() {
    }
}