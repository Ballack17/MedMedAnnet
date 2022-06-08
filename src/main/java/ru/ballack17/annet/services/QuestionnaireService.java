package ru.ballack17.annet.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.ballack17.annet.data.Dto.QuestionnaireDto;
import ru.ballack17.annet.data.entities.Questionnaire;
import ru.ballack17.annet.data.mappers.QuestionnaireMapper;
import ru.ballack17.annet.data.repositories.QuestionnaireRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class QuestionnaireService {

    private final QuestionnaireRepository questionnaireRepository;
    private final QuestionnaireMapper questionnaireMapper;
    private final AnswerService answerService;
    private final UserService userService;
    private final QuestionService questionService;


    public void addQuestionnaireAnswers(QuestionnaireDto questionnaireDto, String login) {
        if (countAnswers(login) < 5) {
            if (questionService.existsById(questionnaireDto.getQuestion_id())){
                if (questionService.findById(questionnaireDto.getQuestion_id()).getIsOpenedAnswer()) {
                    Questionnaire questionnaire = questionnaireMapper.toQuestionnaire(questionnaireDto);
                    questionnaire.setUser_id(userService.findUserByLogin(login).getId());
                    questionnaire.setIsInsert(true);
                    questionnaire.setCorrect(answerService.isCorrectForOpenQuestion(questionnaire.getQuestion_id(), questionnaire.getAnswerText()));
                    questionnaire.setId(UUID.randomUUID());
                    questionnaireRepository.save(questionnaire);
                } else {
                    if (checkIsCloseQuestionHasThatAnswer(questionnaireDto.getQuestion_id(), questionnaireDto.getAnswerText())) {
                        Questionnaire questionnaire = questionnaireMapper.toQuestionnaire(questionnaireDto);
                        questionnaire.setAnswer_id(answerService.findAnswerByAnswerText(questionnaire.getAnswerText()).getId());
                        questionnaire.setUser_id(userService.findUserByLogin(login).getId());
                        questionnaire.setIsInsert(true);
                        questionnaire.setCorrect(answerService.isCorrectForOpenQuestion(questionnaire.getQuestion_id(), questionnaire.getAnswerText()));
                        questionnaire.setId(UUID.randomUUID());
                        questionnaireRepository.save(questionnaire);
                    } else {throw new NoSuchElementException("Please, pick the answer form the existing variants"); }
                }
            } else {
                throw new NoSuchElementException("Recheck the ID of the question");
            }
        } else {throw new ArrayStoreException("you already have 5 answers... test passed");}

        }

    public boolean checkIsCloseQuestionHasThatAnswer (UUID question_id, String answerText) {
        return  answerService.getAllAnswersByQuestionId(question_id).contains(answerService.findAnswerByAnswerText(answerText));
    }

    public int personalCorrectPercentage(String login) {
        return questionnaireRepository.countByCorrectPersonal(userService.findUserByLogin(login).getId());
    }

    public int betterThenYou(String login) {
        return questionnaireRepository.countBetterThenYou(userService.findUserByLogin(login).getId());
    }

    public int worseThenYou(String login) {
        return questionnaireRepository.countWorseThenYou(userService.findUserByLogin(login).getId());
    }

    public int countAllPassed(int testSize) {
        return questionnaireRepository.countUsersPassTest(testSize);
    }

    public int countAllIdealPass(int testSize) {
        return questionnaireRepository.countIdealPass(testSize);
    }

    public int countAllProcessingTest(int testSize) {
        return questionnaireRepository.countUsersProccesingTest(testSize);
    }

    public List<Questionnaire> getPersonalAnswer(String login) {
        return questionnaireRepository.findQuestionnairesByUserId(userService.findUserByLogin(login).getId());
    }

    public int countAnswers(String login) {
        return questionnaireRepository.countByUserId(userService.findUserByLogin(login).getId());
    }
}
