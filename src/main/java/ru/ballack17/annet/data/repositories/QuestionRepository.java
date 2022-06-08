package ru.ballack17.annet.data.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.ballack17.annet.data.entities.Question;

import java.util.List;
import java.util.UUID;

public interface QuestionRepository extends CrudRepository<Question, UUID> {

    List<Question> findAll();

    Question findQuestionById(UUID id);

    boolean existsByQuestionText(String text);

    boolean existsById(UUID id);

}
