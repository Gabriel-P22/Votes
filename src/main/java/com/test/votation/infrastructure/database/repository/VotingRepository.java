package com.test.votation.infrastructure.database.repository;

import com.test.votation.infrastructure.database.entities.VoteEntity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VotingRepository extends MongoRepository<VoteEntity, String> {
}
