package ru.ballack17.annet.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ballack17.annet.data.Dto.AnswerDto;
import ru.ballack17.annet.data.entities.Answer;
import ru.ballack17.annet.data.mappers.AnswerMapper;
import ru.ballack17.annet.data.repositories.AnswerRepository;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerService {

    private final AnswerRepository answerRepository;
    private final AnswerMapper answerMapper;
    private final QuestionService questionService;

    public void addAnswer(AnswerDto answerDto) {
        if(questionService.existsById(answerDto.getQuestionId())) {
            Answer answer = answerMapper.toAnswer(answerDto);
            answer.setId(UUID.randomUUID());
            answer.setIsInsert(true);
            answerRepository.save(answer);
        } else {throw new NoSuchElementException("Recheck the ID of the question");}
    }

    public void addAnswerList(List<AnswerDto> answerDtoList) {
        List<Answer> answerList = answerMapper.toAnswer(answerDtoList);
        answerList.forEach(s -> {
            s.setId(UUID.randomUUID());
            s.setIsInsert(true);
        });
        answerRepository.saveAll(answerList);
    }

    public boolean isCorrectForCloseQuestion(UUID uuid) {
        return answerRepository.findById(uuid).get().getIsCorrect();
    }

    public boolean isCorrectForOpenQuestion(UUID question_id,String answerText) {
        List<Answer> answerList = (answerRepository.findAllByQuestionId(question_id))
                .stream()
                .filter(Answer::getIsCorrect)
                .collect(Collectors.toList());
        return answerList.contains(answerRepository.findAnswerByAnswerText(answerText));
    }

    public List<Answer> getAllAnswersByQuestionId(UUID questionId) {
        return answerRepository.findAllByQuestionId(questionId);
    }

    public List<String> getAllAnswersTextByQuestionId(UUID questionId) {
        return answerRepository.findAllAnswersTextByQuestionId(questionId);
    }

    public Answer findById(UUID id) {
        return answerRepository.findAnswerBy(id);
    }

    public Boolean existsById(UUID id) {
        return answerRepository.existsById(id);
    }

    public Boolean existsByAnswerText(String answerText) {
        return answerRepository.existsByAnswerText(answerText);
    }

    public Answer findAnswerByAnswerText(String answerText) {
        return answerRepository.findAnswerByAnswerText(answerText);
    }
}

