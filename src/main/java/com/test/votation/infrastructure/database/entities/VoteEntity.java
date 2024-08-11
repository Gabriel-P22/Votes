package com.test.votation.infrastructure.database.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document("#{@naming.build('Voting')}")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class VoteEntity {
    String name;
    String year;
    LocalDateTime createdAt;
}
