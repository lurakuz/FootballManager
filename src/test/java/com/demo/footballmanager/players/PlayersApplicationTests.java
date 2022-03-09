package com.demo.footballmanager.players;

import com.demo.footballmanager.controllers.PlayerController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlayersApplicationTests {

    @Autowired
    PlayerController playerController;

    @Test
    public void contextLoads() {
        Assertions.assertThat(playerController).isNot(null);
    }
}