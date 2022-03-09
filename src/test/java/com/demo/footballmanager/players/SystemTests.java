package com.demo.footballmanager.players;

import com.demo.footballmanager.models.dtos.PlayerDto;
import com.demo.footballmanager.models.entities.Player;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

public class SystemTests {

//    @Test
//    public void testCreateReadDelete() {
//        RestTemplate restTemplate = new RestTemplate();
//
//        String url = "http://localhost:8080/players";
//
//        PlayerDto player = new PlayerDto(1L, 37, "Ronaldo", "Cristiano",
//                "1992-01-01", 1L);;
//        ResponseEntity<PlayerDto> entity = restTemplate.postForEntity(url, player, PlayerDto.class);
//
//        PlayerDto[] players = restTemplate.getForObject(url, PlayerDto[].class);
//        Assertions.assertThat(players).extracting(PlayerDto::getFirstName).containsOnly("Lokesh");
//
//        restTemplate.delete(url + "/" + entity.getBody().getId());
//        Assertions.assertThat(restTemplate.getForObject(url, Player[].class)).isEmpty();
//    }

    @Test
    public void testErrorHandlingReturnsBadRequest() {

        RestTemplate restTemplate = new RestTemplate();

        String url = "http://localhost:8080/wrong";

        try {
            restTemplate.getForEntity(url, String.class);
        } catch (HttpClientErrorException e) {
            Assertions.assertThat(e.getStatusCode()).isEqualTo(HttpStatus.BAD_REQUEST);
        }
    }

}