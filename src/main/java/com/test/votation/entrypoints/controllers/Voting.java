package com.test.votation.entrypoints.controllers;

import com.test.votation.entrypoints.dtos.CreateVotingRequest;
import com.test.votation.entrypoints.dtos.VotingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface Voting {
    ResponseEntity<Void> create(@RequestBody CreateVotingRequest body);

    ResponseEntity<List<VotingResponse>> getVotesList();

}
