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
@Table(name = "questionnaire",schema = "med_annet")
public class Questionnaire implements Persistable<UUID> {

    @Id
    @Column("id")
    private UUID id;

    @Column("user_id")
    private UUID user_id;

    @Column("question_id")
    private UUID question_id;

    @Column("answer_id")
    private UUID answer_id;

    @Column("answer_text")
    private String answerText;

    @Column("is_correct")
    private boolean isCorrect;

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
