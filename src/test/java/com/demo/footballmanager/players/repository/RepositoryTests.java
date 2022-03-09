package com.demo.footballmanager.players.repository;

import com.demo.footballmanager.mappers.PlayerMapper;
import com.demo.footballmanager.models.dtos.PlayerDto;
import com.demo.footballmanager.models.entities.Player;
import com.demo.footballmanager.repository.PlayerRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class RepositoryTests {

    @Autowired
    PlayerRepository playerRepository;

    @Autowired
    PlayerMapper playerMapper;

    @Test
    public void testCreateReadDelete() {
        PlayerDto player = new PlayerDto(1L, 37, "Ronaldo", "Cristiano",
                "1992-01-01", 1L);

        playerRepository.save(playerMapper.map(player));

        Iterable<Player> players = playerRepository.findAll();
        Assertions.assertThat(players).extracting(Player::getFirstName).containsOnly("Cristiano");

        playerRepository.deleteAll();
        Assertions.assertThat(playerRepository.findAll()).isEmpty();
    }
}