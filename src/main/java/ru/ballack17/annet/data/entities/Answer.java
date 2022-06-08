package ru.ballack17.annet.data.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.util.UUID;

@Data
@Table(name = "answer",schema = "med_annet")
public class Answer implements Persistable<UUID> {

    @Id
    @Column("id")
    private UUID id;

    @Column("answer_text")
    private String answerText;

    @Column("is_correct")
    private Boolean isCorrect;

    @Column("question_id")
    private UUID question_id;

    @Transient
    @JsonIgnore
    private Boolean isInsert;

    @Override
    @JsonIgnore
    public UUID getId() {
        return id;
    }

    @Override
    @JsonIgnore
    public boolean isNew() {
        return isInsert;
    }
}
