package com.test.votation.entrypoints.controllers;

import com.test.votation.entrypoints.VotingAdapter;
import com.test.votation.entrypoints.dtos.CreateVotingRequest;
import com.test.votation.entrypoints.dtos.VotingResponse;
import com.test.votation.usecases.CreateVote;
import com.test.votation.usecases.GetVoteList;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RequestMapping("voting/")
@RestController
@RequiredArgsConstructor
public class VotingImpl implements Voting {

    private final VotingAdapter adapter;

    private final CreateVote createVote;

    private final GetVoteList getVoteList;

    @Override
    @PostMapping
    public ResponseEntity<Void> create(CreateVotingRequest body) {
        createVote.create(adapter.convert(body));
        return ResponseEntity.accepted().build();
    }

    @Override
    @GetMapping
    public ResponseEntity<List<VotingResponse>> getVotesList() {
        return ResponseEntity.ok(getVoteList.getList());
    }
}
