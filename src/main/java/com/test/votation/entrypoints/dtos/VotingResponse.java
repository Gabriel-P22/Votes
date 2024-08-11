package com.test.votation.entrypoints.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VotingResponse {
    String name;
    int totalVotes;
    LocalDateTime lastUpdated;
}
