package com.demo.footballmanager.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class PageablePlayerDto {

    private List<PlayerDto> players;
    private Long totalCount;
}
