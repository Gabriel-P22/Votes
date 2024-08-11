package com.test.votation.usecases;

import com.test.votation.entrypoints.dtos.VotingResponse;
import com.test.votation.usecases.dtos.VoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransformVoteToResponse {

    public VotingResponse convert(List<VoteDto> list) {
        String name = list.get(0).getName();
        int totalVotes = list.size();
        LocalDateTime lastVote = list.stream()
                .map(VoteDto::getCreatedAt)
                .max(LocalDateTime::compareTo)
                .orElse(null);

        return VotingResponse
                .builder()
                .name(name)
                .totalVotes(totalVotes)
                .lastUpdated(lastVote)
                .build();
    }
}
