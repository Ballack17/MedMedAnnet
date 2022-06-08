package ru.ballack17.annet.data.repositories;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import ru.ballack17.annet.data.entities.Answer;

import java.util.List;
import java.util.UUID;

public interface AnswerRepository extends CrudRepository<Answer, UUID> {

    Answer findAnswerByAnswerText(String answerText);

    boolean existsByAnswerText(String answerText);

    Answer findAnswerBy(UUID id);

    @Query("select * from med_annet.answer a where a.question_id = :question_id")
    List<Answer> findAllByQuestionId(@Param("question_id") UUID uuid);

    @Query("select a.answer_text from med_annet.answer a where a.question_id = :question_id")
    List<String> findAllAnswersTextByQuestionId(@Param("question_id") UUID uuid);

}
