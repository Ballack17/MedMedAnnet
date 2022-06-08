package ru.ballack17.annet.services;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ballack17.annet.data.Dto.QuestionForUserDto;
import ru.ballack17.annet.data.mappers.QuestionMapper;
import ru.ballack17.annet.data.mappers.QuestionnaireMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestingService {

    private final AnswerService answerService;
    private final QuestionService questionService;
    private final QuestionMapper questionMapper;


    public List<QuestionForUserDto> createTest() {
        List<QuestionForUserDto> testList = questionMapper.toQuestionForUserDtoList(questionService.getAllQuestions());
        testList.stream().filter(s -> !s.getIsOpenedAnswer()).forEach(s -> s.setAnswers(answerService.getAllAnswersTextByQuestionId(s.getId())));
        return testList;
    }

}
