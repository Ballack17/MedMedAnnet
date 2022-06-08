package ru.ballack17.annet.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ballack17.annet.data.Dto.QuestionDto;
import ru.ballack17.annet.data.Dto.QuestionForUserDto;
import ru.ballack17.annet.data.entities.Question;
import ru.ballack17.annet.data.mappers.QuestionMapper;
import ru.ballack17.annet.data.repositories.QuestionRepository;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final QuestionMapper questionMapper;

    public void addQuestion(QuestionDto questionDto) {
        if(!questionRepository.existsByQuestionText(questionDto.getQuestionText())){
        Question question = questionMapper.toQuestion(questionDto);
        question.setId(UUID.randomUUID());
        question.setIsInsert(true);
        questionRepository.save(question);
        } else {throw new IllegalArgumentException("Again??? its already there!");}
    }

    public List<Question> getAllQuestions() {
        return questionRepository.findAll();
    }

    public List<QuestionForUserDto> createListForTest() {
        return questionMapper.toQuestionForUserDtoList(getAllQuestions());
    }

    public Question findById(UUID id) {
        return questionRepository.findQuestionById(id);
    }

    public boolean existsById(UUID id) {return questionRepository.existsById(id);}

    public void deleteById(UUID id) {
        if(questionRepository.existsById(id)) {
            questionRepository.deleteById(id);
        } else {throw new NoSuchElementException("There are nothing to delete");}
    }
}
