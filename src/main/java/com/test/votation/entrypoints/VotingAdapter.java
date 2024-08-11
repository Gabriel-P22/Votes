package com.test.votation.entrypoints;

import com.test.votation.entrypoints.dtos.CreateVotingRequest;
import com.test.votation.infrastructure.database.entities.VoteEntity;
import com.test.votation.usecases.dtos.VoteDto;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface VotingAdapter {
    VoteDto convert(CreateVotingRequest voting);

    VoteEntity convert(VoteDto voteDto);

    List<VoteDto> contertToList(List<VoteEntity> list);

}
