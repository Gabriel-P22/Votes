package com.test.votation.usecases;

import com.test.votation.orchestrator.VoteOrchestrator;
import com.test.votation.usecases.dtos.VoteDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CreateVote {

    private final VoteOrchestrator orchestrator;

    public void create(VoteDto dto) {
        orchestrator.create(dto);
    }
}
