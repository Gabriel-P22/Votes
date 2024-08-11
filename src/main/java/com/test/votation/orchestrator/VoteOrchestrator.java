package com.test.votation.orchestrator;

import com.test.votation.entrypoints.VotingAdapter;
import com.test.votation.infrastructure.database.entities.VoteEntity;
import com.test.votation.infrastructure.database.repository.VotingRepository;
import com.test.votation.usecases.dtos.VoteDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
@AllArgsConstructor
@Slf4j
public class VoteOrchestrator {

    private final VotingRepository repository;

    private final VotingAdapter adapter;

    public void create(VoteDto dto) {
        try {
            dto.setCreatedAt(LocalDateTime.now());
            repository.save(adapter.convert(dto));
        } catch (Exception e) {
            log.error("Error on create entity" + e.getCause());
        }
    }

    public List<VoteEntity> getAll() {
        return repository.findAll();
    }

}
