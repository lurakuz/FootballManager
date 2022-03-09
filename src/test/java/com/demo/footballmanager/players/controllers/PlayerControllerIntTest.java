package com.demo.footballmanager.players.controllers;

import com.demo.footballmanager.controllers.PlayerController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@ExtendWith(SpringExtension.class)
@WebMvcTest(PlayerController.class)
class PlayerControllerIntTest {

    @Autowired
    private MockMvc mvc;

    @Test
    void getAllPlayers() {
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

    @Test
    void createPlayer() {
    }

    @Test
    void updatePlayerById() {
    }

    @Test
    void deletePlayerById() {
    }

    @Test
    void transferPlayerPage() {
    }

    @Test
    void transferPlayer() {
    }
}