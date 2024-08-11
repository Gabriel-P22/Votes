package com.test.votation.usecases;

import com.test.votation.entrypoints.VotingAdapter;
import com.test.votation.entrypoints.dtos.VotingResponse;
import com.test.votation.orchestrator.VoteOrchestrator;
import com.test.votation.usecases.dtos.VoteDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GetVoteList {

    private final VoteOrchestrator orchestrator;

    private final TransformVoteToResponse transformVoteToResponse;

    private final VotingAdapter adapter;

    public List<VotingResponse> getList() {
        List<VoteDto> voteList = adapter.contertToList(orchestrator.getAll());

        Map<String, VotingResponse> map = voteList
                .stream()
                        .collect(Collectors.groupingBy(
                                VoteDto::getName,
                                Collectors.collectingAndThen(
                                        Collectors.toList(),
                                        transformVoteToResponse::convert
                                )
                        ));

        return List.copyOf(map.values());
    }
}
