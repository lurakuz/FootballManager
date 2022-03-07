package com.demo.footballmanager.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TransferDetailsDto {

    private Long teamId;
    private Long playerId;
}
